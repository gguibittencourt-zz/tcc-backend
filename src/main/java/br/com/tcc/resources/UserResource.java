package br.com.tcc.resources;

import br.com.tcc.dto.ReferenceModel;
import br.com.tcc.dto.User;
import br.com.tcc.dto.UserLogin;
import br.com.tcc.exceptions.BusinessException;
import br.com.tcc.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Controller
public class UserResource {

    private final UserService userService;
    private static final Gson GSON = new Gson();

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("/login")
    public Response login(String userJson) throws Exception {
        User user = GSON.fromJson(userJson, User.class);
        UserLogin userLogin = this.userService.login(user);

        return Response.ok(GSON.toJson(userLogin))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @POST
    @Path("/register")
    public Response register(String userJson) throws BusinessException {
        User user = GSON.fromJson(userJson, User.class);
        this.userService.register(user);
        return Response.ok(GSON.toJson(user))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PUT
    @Path("/{idUser}")
    public Response update(@PathParam("idUser") Integer idUser, String userJson) {
        User user = GSON.fromJson(userJson, User.class);
        this.userService.update(idUser, user);
        return Response.ok()
                .build();
    }

    @GET
    @Path("/{idUser}")
    public Response get(@PathParam("idUser") Integer idUser) {
        User user = this.userService.get(idUser);
        return Response.ok(GSON.toJson(user))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
