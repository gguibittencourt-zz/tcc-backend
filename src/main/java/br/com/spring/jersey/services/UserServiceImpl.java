package br.com.spring.jersey.services;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String ok() {
        return "Ok! " + new Date();
    }
}
