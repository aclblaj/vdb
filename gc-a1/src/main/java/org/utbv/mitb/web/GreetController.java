package org.utbv.mitb.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.utbv.mitb.domain.User;
import org.utbv.mitb.domain.UserDao;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@URLMappings(mappings = { 
		@URLMapping(id = "anagramView", pattern = "/anagram/", viewId = "/pages/anagram.xhtml"),
		@URLMapping(id = "createView", pattern = "/create/", viewId = "/pages/create.xhtml"),
		@URLMapping(id = "bookView", pattern = "/book/", viewId = "/pages/createbook.xhtml"),
		@URLMapping(id = "accordionView", pattern = "/accordion/", viewId = "/pages/accordion.xhtml"),
		@URLMapping(id = "greetView", pattern = "/greet/", viewId = "/pages/greet.xhtml"),
		@URLMapping(id = "chartView", pattern = "/chart/", viewId = "/pages/pie.xhtml"),
		@URLMapping(id = "carView", pattern = "/cars/", viewId = "/pages/cars.xhtml")
})

@Named
@RequestScoped
public class GreetController {

    @Inject
    private UserDao userDao;

    private String username;

    private String greeting;

    public void greet() {
        User user = userDao.getForUsername(username);
        if (user != null) {
            greeting = "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
        } else {
            greeting = "No such user exists! Use 'emuster' or 'jdoe'";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGreeting() {
        return greeting;
    }

}
