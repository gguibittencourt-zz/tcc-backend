package br.com.tcc.resources;

import br.com.tcc.dao.metadata.enums.AssessmentStatus;
import br.com.tcc.dto.Assessment;
import br.com.tcc.dto.ReferenceModel;
import br.com.tcc.services.AssessmentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("assessments")
@Controller
public class AssessmentResource {

    private static final Gson GSON = new Gson();
    private final AssessmentService assessmentService;

    @Autowired
    public AssessmentResource(AssessmentService assessment) {
        this.assessmentService = assessment;
    }

    @GET
    @Path("/{idAssessment}")
    public Response get(@PathParam("idAssessment") Integer idAssessment) {
        Assessment assessment = this.assessmentService.get(idAssessment);
        return Response.ok(GSON.toJson(assessment))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/list/{idUser}")
    public Response list(@PathParam("idUser") Integer idUser) {
        Collection<Assessment> assessments = this.assessmentService.list(idUser);
        return Response.ok(GSON.toJson(assessments))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @POST
    public Response register(String assessmentJson) {
        Assessment assessment = GSON.fromJson(assessmentJson, Assessment.class);
        this.assessmentService.register(assessment);
        return Response.ok(GSON.toJson(assessment))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/finish")
    public Response finish(String assessmentJson) {
        Assessment assessment = GSON.fromJson(assessmentJson, Assessment.class);
        assessment.setStatus(AssessmentStatus.finalized);
        Assessment finish = this.assessmentService.finish(assessment);

        return Response.ok(GSON.toJson(finish))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idAssessment}")
    public Response update(@PathParam("idAssessment") Integer idAssessment, String assessmentJson) {
        Assessment assessment = GSON.fromJson(assessmentJson, Assessment.class);
        this.assessmentService.update(idAssessment, assessment);
        return Response.ok()
                .build();
    }

    @DELETE
    @Path("/{idAssessment}")
        public Response delete(@PathParam("idAssessment") Integer idAssessment) {
        this.assessmentService.delete(idAssessment);
        return Response.ok()
                .build();
    }
}
