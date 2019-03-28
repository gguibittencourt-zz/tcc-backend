package br.com.tcc.resources;

import br.com.tcc.dto.Evaluation;
import br.com.tcc.services.EvaluationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("evaluations")
@Controller
public class EvaluationResource {

    private static final Gson GSON = new Gson();
    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationResource(EvaluationService evaluation) {
        this.evaluationService = evaluation;
    }

    @GET
    @Path("/{idEvaluation}")
    public Response get(@PathParam("idEvaluation") Integer idEvaluation) {
        Evaluation evaluation = this.evaluationService.get(idEvaluation);
        return Response.ok(GSON.toJson(evaluation))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/list/{idEvaluations}")
    public Response getByList(@PathParam("idEvaluations") String idEvaluations) {
        return Response.ok()
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    public Response list() {
        Collection<Evaluation> evaluations = this.evaluationService.list();
        return Response.ok(GSON.toJson(evaluations))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    public Response register(String evaluationJson) {
        Evaluation evaluation = GSON.fromJson(evaluationJson, Evaluation.class);
        this.evaluationService.register(evaluation);
        return Response.ok(GSON.toJson(evaluation))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idEvaluation}")
    public Response update(@PathParam("idEvaluation") Integer idEvaluation, String evaluationJson) {
        Evaluation evaluation = GSON.fromJson(evaluationJson, Evaluation.class);
        this.evaluationService.update(idEvaluation, evaluation);
        return Response.ok()
                .build();
    }

    @DELETE
    @Path("/{idEvaluation}")
    public Response delete(@PathParam("idEvaluation") Integer idEvaluation) {
        this.evaluationService.delete(idEvaluation);
        return Response.ok()
                .build();
    }
}
