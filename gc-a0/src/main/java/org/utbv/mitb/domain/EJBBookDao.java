package org.utbv.mitb.domain;

import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
@Named
public class EJBBookDao implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Book getForTitle(String title){
        try {
            Query query = entityManager.createQuery("select b from Book b where b.title = :title");
            query.setParameter("title", title);
            return (Book) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createBook(Book book) {
        entityManager.persist(book);
    }

}