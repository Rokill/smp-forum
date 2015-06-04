package ru.auquid.forum.entity.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.EJB;

import ru.auquid.forum.beans.UserBeanRemote;
import ru.auquid.forum.entity.Leaf;
import ru.auquid.forum.entity.User;

public class ForumUser extends User {
	

	private boolean canLike;

	public ForumUser(User user) {
		super(user.getUsername(), user.getPassword());
		checkCanLike(user.getLikeTime());
	}
	
	private void checkCanLike(Date date){
		if (date != null) {
			GregorianCalendar oneHourMore = new GregorianCalendar();
			oneHourMore.setTime(date);
			oneHourMore.add(Calendar.HOUR_OF_DAY, 1);
			setCanLike(new Date().after(oneHourMore.getTime()));
		} else {
			setCanLike(true);
		}
	}

	public boolean isCanLike() {
		return canLike;
	}

	public void setCanLike(boolean canLike) {
		this.canLike = canLike;
	}

}
