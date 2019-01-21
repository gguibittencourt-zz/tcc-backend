package br.com.spring.jersey.resources;

import br.com.spring.jersey.dto.ReferenceModel;
import br.com.spring.jersey.services.ReferenceModelService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("reference-models")
@Controller
public class ReferenceModelResource {

    private static final Gson GSON = new Gson();
    private final ReferenceModelService referenceModelService;

    @Autowired
    public ReferenceModelResource(ReferenceModelService referenceModelService) {
        this.referenceModelService = referenceModelService;
    }

    @GET
    @Path("/{idReferenceModel}")
    public Response get(@PathParam("idReferenceModel") Integer idReferenceModel) {
        ReferenceModel referenceModel = this.referenceModelService.get(idReferenceModel);
        return Response.ok(GSON.toJson(referenceModel))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    public Response list() {
        Collection<ReferenceModel> referenceModels = this.referenceModelService.list();
        return Response.ok(GSON.toJson(referenceModels))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    public Response register(String referenceModelJson) {
        ReferenceModel referenceModel = GSON.fromJson(referenceModelJson, ReferenceModel.class);
        this.referenceModelService.register(referenceModel);
        return Response.ok(GSON.toJson(referenceModel))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idReferenceModel}")
    public Response update(@PathParam("idReferenceModel") Integer idReferenceModel, String referenceModelJson) {
        ReferenceModel referenceModel = GSON.fromJson(referenceModelJson, ReferenceModel.class);
        this.referenceModelService.update(idReferenceModel, referenceModel);
        return Response.ok()
                .build();
    }


    @DELETE
    @Path("/{idReferenceModel}")
    public Response delete(@PathParam("idReferenceModel") Integer idReferenceModel) {
        this.referenceModelService.delete(idReferenceModel);
        return Response.ok()
                .build();
    }
}
