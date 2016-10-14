package org.utbv.mitb.domain;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


@Stateless
@ManagedBean
public class EJBBookDao implements BookDao {

    @Inject
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