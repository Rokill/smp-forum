package ru.auquid.forum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import ru.auquid.forum.entity.Leaf;
import ru.auquid.forum.entity.helper.Root;

public class LeafDAO extends GenericDAO<Leaf> {

	public LeafDAO() {
	}

	public List<Leaf> getTreeFromRoot(Leaf root) {
		TypedQuery<Leaf> query = em.createNamedQuery("Leaf.findByRootId",
				Leaf.class);
		query.setParameter("rootId", root.getId());
		return query.getResultList();
	}

	public List<Root> getRootList(Leaf root) {
		TypedQuery<Leaf> query = em.createNamedQuery("Leaf.findByRootId",
				Leaf.class);
		query.setParameter("rootId", root.getId());
		List<Leaf> leafList = query.getResultList();
		List<Root> list = new ArrayList<Root>();
		for (Leaf l : leafList) {
			list.add(new Root(l));
		}
		return list;
	}

	public boolean isRoot(Leaf leaf) {
		TypedQuery<Leaf> query = em.createNamedQuery("Leaf.findByRootId",
				Leaf.class);
		query.setParameter("rootId", leaf.getId());
		if (query.getResultList().size() == 0)
			return false;
		else
			return true;
	}

	public boolean isLastRoot(Leaf leaf) {
		TypedQuery<Leaf> query = em.createNamedQuery("Leaf.findByRootId",
				Leaf.class);
		query.setParameter("rootId", leaf.getId());
		if (query.getResultList().size() > 0)
			return query.getResultList().get(0).isLastLeaf();
		else
			return false;
	}
}
