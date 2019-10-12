package br.com.tcc.resources;

import br.com.tcc.dto.DataSource;
import br.com.tcc.services.DataSourceService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("data-sources")
@Controller
public class DataSourceResource {

    private static final Gson GSON = new Gson();
    private final DataSourceService dataSourceService;

    @Autowired
    public DataSourceResource(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    @GET
    @Path("/{idDataSource}")
    public Response get(@PathParam("idDataSource") Integer idDataSource) {
        DataSource dataSource = this.dataSourceService.get(idDataSource);
        return Response.ok(GSON.toJson(dataSource))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/list/{idCompany}")
    public Response list(@PathParam("idCompany") Integer idCompany) {
        Collection<DataSource> dataSources = this.dataSourceService.list(idCompany);
        return Response.ok(GSON.toJson(dataSources))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    public Response register(String dataSourceJson) {
        DataSource dataSource = GSON.fromJson(dataSourceJson, DataSource.class);
        Integer idDataSource = this.dataSourceService.register(dataSource);
        dataSource.setIdDataSource(idDataSource);
        return Response.ok(GSON.toJson(dataSource))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idDataSource}")
    public Response update(@PathParam("idDataSource") Integer idDataSource, String dataSourceJson) {
        DataSource dataSource = GSON.fromJson(dataSourceJson, DataSource.class);
        this.dataSourceService.update(idDataSource, dataSource);
        return Response.ok()
                .build();
    }


    @DELETE
    @Path("/{idDataSource}")
    public Response delete(@PathParam("idDataSource") Integer idDataSource) {
        this.dataSourceService.delete(idDataSource);
        return Response.ok()
                .build();
    }
}
