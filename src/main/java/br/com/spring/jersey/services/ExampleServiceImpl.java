package br.com.spring.jersey.services;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String ok() throws Exception {
        return "Ok! " + new Date();
    }
}
