package br.com.spring.jersey.resources;

import br.com.spring.jersey.services.ExampleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("example")
@Controller
public class ExampleResource {

    @Autowired
    private ExampleService exampleService;

    @GET
    @Produces("application/json")
    public String listar() throws Exception {
        return new Gson().toJson(exampleService.ok());
    }

    public void setExampleService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

}
