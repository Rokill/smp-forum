package ru.auquid.forum.beans;

import javax.ejb.Remote;
import ru.auquid.forum.entity.User;

@Remote
public interface BranchBeanRemote {
	
	public void createSubBranch(Integer rootId, String name, User user);

	public void createMsgLeaf(String msg, Integer rootId, User user);

	public void createNewTheme(Integer rootId, String msg, User user);
}
