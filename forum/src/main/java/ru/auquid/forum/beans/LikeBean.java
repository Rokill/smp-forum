package ru.auquid.forum.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.entity.Leaf;

@Stateless
@Remote(LikeBeanRemote.class)
public class LikeBean implements LikeBeanRemote {

	@Override
	public void like(int leafId) {
		LeafDAO dao = new LeafDAO();
		try {
			Leaf leaf = dao.get(leafId);
			leaf.setRating(leaf.getRating() + 1);
			dao.persist(leaf);
		} finally {
			if (dao != null)
				dao.close();
		}

	}

}
