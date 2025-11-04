package org.utbv.mitb.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.utbv.mitb.domain.Book;
import org.utbv.mitb.domain.BookDao;

@Named
@RequestScoped
public class BookController {
    @Inject
    private FacesContext facesContext;

    @Inject
    private BookDao bookDao;

    @Named
    @Produces
    @RequestScoped
    private Book newBook = new Book();

    public String create() {
        try {
            bookDao.createBook(newBook);
            String message = "A new book with id " + newBook.getId() + " has been created successfully";
            facesContext.addMessage(null, new FacesMessage(message));
        } catch (Exception e) {
            String message = "An error has occured while creating the user (see log for details)";
            facesContext.addMessage(null, new FacesMessage(message));
        }
        return "pretty:bookView";
    }
}
