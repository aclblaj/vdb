
package org.utbv.mitb.domain;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@ManagedBean
public class EJBUserDao implements UserDao {

	private final static Logger logger = LoggerFactory.getLogger(EJBUserDao.class);

	@Inject
	private EntityManager entityManager;

	public User getForUsername(String username) {
		try {
			Query query = entityManager.createQuery("select u from User u where u.username = :username");
			query.setParameter("username", username);
			return (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public String createUser(User user) {
		List<?> usernames = (List<?>) entityManager.createQuery("Select u.username from User u").getResultList();
		if (usernames.contains(user.getUsername())) {
			logger.error("Username already taken.");
			return "Username already taken.";
		} else {
			try {
				entityManager.merge(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		logger.info("User successfully registered.");
		return "User successfully registered.";
	}

	@Override
	public List<User> getAll() {
		try {
			Query query = entityManager.createQuery("select u from User u");
			List<?> result = query.getResultList();
			return (List<User>) result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Long getMaxId() {
		if ((Long) entityManager.createQuery("Select max(u.id) from User u").getSingleResult() != null)
			return (Long) entityManager.createQuery("Select max(u.id) from User u").getSingleResult();
		else
			return 0L;
	}

	@Override
	public User getAppuser() {
		return (User) entityManager.createQuery("Select u from User u").getResultList().get(0);
	}

	@Override
	public User find(String username, String securityphrase, String string) {
		try {
			Query query = entityManager.createQuery(
					"Select u from User u where u.username = :username AND u.securityphrase = :securityphrase");
			query.setParameter("username", username);
			query.setParameter("securityphrase", securityphrase);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User find(String username, String password) {
		try {
			Query query = entityManager
					.createQuery("Select u from User u where u.username = :username AND u.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User find(String username) {
		try {
			Query query = entityManager.createQuery("Select u from User u where u.username = :username");
			query.setParameter("username", username);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
