package ru.auquid.forum.beans;

import java.util.Date;

import javax.ejb.Remote;
import javax.persistence.NoResultException;

import ru.auquid.forum.dao.UserDAO;
import ru.auquid.forum.entity.User;

@Remote
public interface UserBeanRemote {

	public User login(String name, String password);

	public User registrate(String name, String pass);
	
	public User like(User user);

	public User get(String username);

}
