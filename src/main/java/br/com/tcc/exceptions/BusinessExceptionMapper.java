package br.com.tcc.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    public Response toResponse(BusinessException ex) {
        return Response.status(512)
                .entity(ex)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}