package ru.auquid.forum.entity.helper;

import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.entity.Leaf;

public class Root extends Leaf {

	private String lastMsg;

	public Root(Leaf leaf) {
		super(leaf.getId(), leaf.getUsername(), leaf.getPostTime(), leaf
				.getMsg(), leaf.getUpperLeafId(), leaf.isLastLeaf());
		getLastMsg(leaf);
	}

	private void getLastMsg(Leaf leaf) {
		LeafDAO dao = null;
		Leaf newest = null;
		try {
			dao = new LeafDAO();
			for (Leaf l : dao.getTreeFromRoot(leaf)) {
				if (newest == null || newest.getPostTime() == null)
					newest = l;
				else if (l.getPostTime() != null && newest.getPostTime().before(l.getPostTime()))
					newest = l;
			}
		} finally {
			if (dao != null)
				dao.close();
		}
		if (newest != null)
		{
			lastMsg = shorten(newest.getMsg());
		}
	}

	private String shorten(String msg) {
		if (msg.length()>120)
			return msg.substring(0,120);
		return msg;
	}

	public String getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}
}
