package br.com.spring.jersey.resources;

import br.com.spring.jersey.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("users")
@Controller
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces("application/json")
    public String listar() {
        return new Gson().toJson(userService.ok());
    }
}
