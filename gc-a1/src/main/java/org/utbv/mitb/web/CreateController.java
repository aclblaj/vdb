package org.utbv.mitb.web;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

import org.utbv.mitb.domain.User;
import org.utbv.mitb.domain.UserDao;

@Named
@RequestScoped
public class CreateController {
    @Inject
    private FacesContext facesContext;

    @Inject
    private UserDao userDao;

    private User newUser = new User();
    private List<User> users;

    public String create() {
        try {
            userDao.createUser(newUser);
            String message = "A new user with id " + newUser.getId() + " has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while creating the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
        return "pretty:createView";
    }

    public List<User> getUsers() {
        return users;
    }

    @PostConstruct
    public void init() {
        users = userDao.getAll();
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
}
