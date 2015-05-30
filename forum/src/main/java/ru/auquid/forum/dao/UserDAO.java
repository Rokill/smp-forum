package ru.auquid.forum.dao;

import javax.persistence.TypedQuery;

import ru.auquid.forum.entity.User;

public class UserDAO extends GenericDAO<User> {
	
	public User findByName(String name){
		TypedQuery<User> query = em.createNamedQuery("User.findByName",
				User.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
