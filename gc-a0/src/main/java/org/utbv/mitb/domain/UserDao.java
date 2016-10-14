package org.utbv.mitb.domain;

import java.util.List;

public interface UserDao {
    User getForUsername(String username);

    String createUser(User user);

	List<User> getAll();

	Long getMaxId();

	User getAppuser();

	User find(String username, String securityphrase, String string);

	User find(String username, String password);

	User find(String username);
}
