package ru.auquid.forum.beans;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import ru.auquid.forum.dao.UserDAO;
import ru.auquid.forum.entity.User;
import ru.auquid.forum.entity.helper.ForumUser;

@Stateless
@Remote(UserBeanRemote.class)
public class UserBean implements UserBeanRemote {

	public User login(String name, String password) {
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

	public User registrate(String name, String pass) {
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
	
	public User like(User user){
		UserDAO dao = new UserDAO();
		try {
			User u = dao.findByName(user.getUsername());
			u.setLikeTime(new Date());
			dao.persist(u);
			return u;
		} finally {
			if (dao != null)
				dao.close();
		}
	}

	@Override
	public User get(String username) {
		UserDAO dao = new UserDAO();
		try {
			User user = dao.findByName(username);
			return user;
		} finally {
			if (dao != null)
				dao.close();
		}
	}

}
