package br.com.spring.jersey.exceptions;

import java.util.List;

public class BusinessException extends Exception  {

    private List<String> erros;

    public BusinessException(List<String> erro) {
        this.erros = erro;
    }

    public List<String> getErros() {
        return erros;
    }
}