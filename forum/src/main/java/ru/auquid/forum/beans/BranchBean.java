package ru.auquid.forum.beans;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.dao.UserDAO;
import ru.auquid.forum.entity.Leaf;
import ru.auquid.forum.entity.User;

@Stateless
@Remote(BranchBeanRemote.class)
public class BranchBean implements BranchBeanRemote {

	
	public BranchBean(){
	}

	public void createSubBranch(Integer rootId, String name, User user) {
		LeafDAO dao = new LeafDAO();
		try {
			Leaf toSave = new Leaf(user, name, dao.get(rootId));
			toSave.setLastLeaf(false);
			dao.persist(toSave);
		} finally {
			if (dao != null)
				dao.close();
		}
	}

	public void createMsgLeaf(String msg, Integer rootId, User user) {
		String name = user.getUsername();
		LeafDAO dao = null;
		UserDAO userDao = null;
		try {
			dao = new LeafDAO();
			userDao = new UserDAO();
			try {
				Leaf leaf = new Leaf(userDao.findByName(name), msg,
						(dao.get(rootId)));
				leaf.setLastLeaf(true);
				dao.persist(leaf);
			} catch (Exception ex) {
			}
		} finally {
			if (dao != null)
				dao.close();
			if (userDao != null)
				userDao.close();
		}
	}

	public void createNewTheme(Integer rootId, String msg, User user) {
		LeafDAO dao = new LeafDAO();
		try {
			Leaf toSave = new Leaf(user, msg, dao.get(rootId));
			toSave.setLastLeaf(false);
			dao.persist(toSave);
			Leaf leaf = new Leaf(user, msg, toSave);
			leaf.setLastLeaf(true);
			dao.persist(leaf);
		} finally {
			if (dao != null)
				dao.close();
		}
	}
	
	public void updateName(Integer id, String name) {
		LeafDAO dao = new LeafDAO();
		try {
			Leaf root = dao.get(id);
			root.setMsg(name);
			dao.persist(root);
		} finally {
			if (dao != null)
				dao.close();
		}
		
	}

	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		// TODO Auto-generated method stub
		
	}

	


}
