package br.com.tcc.exceptions;

import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Service
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    public Response toResponse(BusinessException ex) {
        return Response.status(422)
                .entity(ex.getError())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}