package br.com.spring.jersey.resources;

import br.com.spring.jersey.dto.MeasurementFramework;
import br.com.spring.jersey.services.MeasurementFrameworkService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("measurement-frameworks")
@Controller
public class MeasurementFrameworkResource {

    private static final Gson GSON = new Gson();
    private final MeasurementFrameworkService measurementFramework;

    @Autowired
    public MeasurementFrameworkResource(MeasurementFrameworkService measurementFramework) {
        this.measurementFramework = measurementFramework;
    }

    @GET
    @Path("/{idMeasurementFramework}")
    public Response get(@PathParam("idMeasurementFramework") Integer idMeasurementFramework) {
        MeasurementFramework measurementFramework = this.measurementFramework.get(idMeasurementFramework);
        return Response.ok(GSON.toJson(measurementFramework))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    public Response list() {
        Collection<MeasurementFramework> measurementFrameworks = this.measurementFramework.list();
        return Response.ok(GSON.toJson(measurementFrameworks))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    public Response register(String measurementFrameworkJson) {
        MeasurementFramework measurementFramework = GSON.fromJson(measurementFrameworkJson, MeasurementFramework.class);
        this.measurementFramework.register(measurementFramework);
        return Response.ok(GSON.toJson(measurementFramework))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idMeasurementFramework}")
    public Response update(@PathParam("idMeasurementFramework") Integer idMeasurementFramework, String measurementFrameworkJson) {
        MeasurementFramework measurementFramework = GSON.fromJson(measurementFrameworkJson, MeasurementFramework.class);
        this.measurementFramework.update(idMeasurementFramework, measurementFramework);
        return Response.ok()
                .build();
    }

    @DELETE
    @Path("/{idMeasurementFramework}")
    public Response delete(@PathParam("idMeasurementFramework") Integer idMeasurementFramework) {
        this.measurementFramework.delete(idMeasurementFramework);
        return Response.ok()
                .build();
    }
}
