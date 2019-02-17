package br.com.tcc.services.impl;

import br.com.tcc.dao.UserDAO;
import br.com.tcc.dto.Company;
import br.com.tcc.dto.User;
import br.com.tcc.dto.UserLogin;
import br.com.tcc.exceptions.BusinessException;
import br.com.tcc.services.CompanyService;
import br.com.tcc.services.UserService;
import br.com.tcc.util.Constants;
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

    @Override
    public User get(Integer idUser) {
        return this.userDAO.get(idUser);
    }

    @Override
    public int update(Integer idUser, User user) {
        return this.userDAO.update(idUser, user);
    }
}
