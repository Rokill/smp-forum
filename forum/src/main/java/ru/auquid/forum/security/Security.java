package ru.auquid.forum.security;

import javax.persistence.NoResultException;

import ru.auquid.forum.dao.UserDAO;
import ru.auquid.forum.entity.User;

public class Security {

	public static User login(String name, String password) {
		UserDAO dao = new UserDAO();
		try {
			User user = dao.findByName(name);
			if (user.getPassword().equals(password))
				return user;
			else
				return null;
		} catch (NoResultException nre) {
			return null;
		} finally {
			if (dao != null)
				dao.close();
		}
	}

	public static User registrate(String name, String pass) {
		UserDAO dao = new UserDAO();
		try {
			User user = dao.findByName(name);
			return null;
		} catch (NoResultException nre) {
			User newUser = new User(name, pass);
			dao.persist(newUser);
			return newUser;
		} finally {
			if (dao != null)
				dao.close();
		}
	}

}
