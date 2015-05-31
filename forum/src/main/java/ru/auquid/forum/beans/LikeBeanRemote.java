package ru.auquid.forum.beans;

import javax.ejb.Remote;

@Remote
public interface LikeBeanRemote {
	
	public void like(int leadId);

}
