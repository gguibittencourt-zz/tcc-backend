package br.com.spring.jersey.services;

import br.com.spring.jersey.dao.UserDAO;
import br.com.spring.jersey.dto.User;
import br.com.spring.jersey.dto.UserLogin;
import br.com.spring.jersey.exceptions.BusinessException;
import br.com.spring.jersey.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserLogin login(User user) throws Exception {
        User actualUser = this.userDAO.get(user.getUsername(), user.getPassword());
        if (actualUser != null) {
            byte[] encode = Base64.getEncoder().encode(user.getBytesUsernameAndPassword());
            String token = new String(encode);
            UserLogin userLogin = new UserLogin(actualUser);
            userLogin.setToken(token);
            return userLogin;
        }
       throw new Exception();
    }

    @Override
    public boolean register(User user) {
        return this.userDAO.register(user) > 0;
    }

}
