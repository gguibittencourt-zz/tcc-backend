package br.com.tcc.resources;

import br.com.tcc.dto.MeasurementFramework;
import br.com.tcc.services.MeasurementFrameworkService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static br.com.tcc.util.Constants.INTEGER_LIST_TYPE;

@Path("measurement-frameworks")
@Controller
public class MeasurementFrameworkResource {

    private static final Gson GSON = new Gson();
    private final MeasurementFrameworkService measurementFrameworkService;

    @Autowired
    public MeasurementFrameworkResource(MeasurementFrameworkService measurementFramework) {
        this.measurementFrameworkService = measurementFramework;
    }

    @GET
    @Path("/{idMeasurementFramework}")
    public Response get(@PathParam("idMeasurementFramework") Integer idMeasurementFramework) {
        MeasurementFramework measurementFramework = this.measurementFrameworkService.get(idMeasurementFramework);
        return Response.ok(GSON.toJson(measurementFramework))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    @Path("/list")
    public Response getByList(String idsMeasurementFrameworks) {
        Collection<Integer> ids = GSON.fromJson(idsMeasurementFrameworks, INTEGER_LIST_TYPE);
        Collection<MeasurementFramework> measurementFrameworks = this.measurementFrameworkService.listByIds(ids);
        return Response.ok(GSON.toJson(measurementFrameworks))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }


    @GET
    public Response list() {
        Collection<MeasurementFramework> measurementFrameworks = this.measurementFrameworkService.list();
        return Response.ok(GSON.toJson(measurementFrameworks))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    public Response register(String measurementFrameworkJson) {
        MeasurementFramework measurementFramework = GSON.fromJson(measurementFrameworkJson, MeasurementFramework.class);
        this.measurementFrameworkService.register(measurementFramework);
        return Response.ok(GSON.toJson(measurementFramework))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idMeasurementFramework}")
    public Response update(@PathParam("idMeasurementFramework") Integer idMeasurementFramework, String measurementFrameworkJson) {
        MeasurementFramework measurementFramework = GSON.fromJson(measurementFrameworkJson, MeasurementFramework.class);
        this.measurementFrameworkService.update(idMeasurementFramework, measurementFramework);
        return Response.ok()
                .build();
    }

    @DELETE
    @Path("/{idMeasurementFramework}")
    public Response delete(@PathParam("idMeasurementFramework") Integer idMeasurementFramework) {
        this.measurementFrameworkService.delete(idMeasurementFramework);
        return Response.ok()
                .build();
    }
}
