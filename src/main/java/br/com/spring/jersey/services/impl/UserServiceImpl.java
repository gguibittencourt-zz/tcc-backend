package br.com.spring.jersey.services.impl;

import br.com.spring.jersey.dao.UserDAO;
import br.com.spring.jersey.dto.Company;
import br.com.spring.jersey.dto.User;
import br.com.spring.jersey.dto.UserLogin;
import br.com.spring.jersey.exceptions.BusinessException;
import br.com.spring.jersey.services.CompanyService;
import br.com.spring.jersey.services.UserService;
import br.com.spring.jersey.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final CompanyService companyService;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, CompanyService companyService) {
        this.userDAO = userDAO;
        this.companyService = companyService;
    }

    @Override
    public UserLogin login(User user) throws BusinessException {
        User actualUser = this.userDAO.get(user.getUsername(), user.getPassword());
        if (actualUser != null) {
            byte[] encode = Base64.getEncoder().encode(user.getBytesUsernameAndPassword());
            String token = new String(encode);
            UserLogin userLogin = new UserLogin(actualUser);
            userLogin.setToken(token);
            return userLogin;
        }
       throw new BusinessException(Constants.LOGIN_ERROR);
    }

    @Override
    public Integer register(User user) {
        Company company = new Company()
                .setName("")
                .setContributors(0)
                .setProjects(0)
                .setOccupationArea("");
        Integer idCompany = this.companyService.register(company);
        return this.userDAO.register(user.setIdCompany(idCompany)).getIdUser();
    }

}
