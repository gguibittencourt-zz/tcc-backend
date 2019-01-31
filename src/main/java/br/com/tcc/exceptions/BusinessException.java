package br.com.tcc.exceptions;

public class BusinessException extends Exception {


    private static final long serialVersionUID = -8999932578270387947L;
    private String error;

    public BusinessException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}