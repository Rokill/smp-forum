package ru.auquid.forum.entity.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.ocpsoft.prettytime.PrettyTime;

import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.entity.Leaf;

public class MessageLeaf extends Leaf {

	private boolean mainMsg;
	private String time;

	public MessageLeaf(Leaf l) {
		super(l.getId(), l.getUsername(), l.getPostTime(),
				parseMsg(l.getMsg()), l.getUpperLeafId(), l.isLastLeaf());
		setRating(l.getRating());
		checkMain();
		PrettyTime p = new PrettyTime(new Locale("en"));
		setTime(p.format(l.getPostTime()));
	}

	private static String parseMsg(String msg) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < msg.length(); i++) {
			String sub = "";
			if (i + 5 < msg.length())
				sub = msg.substring(i, i + 5);
			if (sub.equals("[IMG]")) {
				int startOfUrl = i + 5;
				while (!sub.equals("[/IMG]")) {
					sub = msg.substring(i, i + 6);
					i++;
					if (i + 5 >= msg.length())
						return msg;
				}
				int endOfUrl = i - 1;
				String url = msg.substring(startOfUrl, endOfUrl);
				str.append("<br><img SRC=\"" + url
						+ "\" width=\"250\" heigth=\"250\"><br>");
				i = i + 6;
			} else {
				str.append(msg.charAt(i));
			}
		}
		return str.toString();
	}

	private void checkMain() {
		if (getPostTime() != null) {
			GregorianCalendar oneHourMore = new GregorianCalendar();
			oneHourMore.setTime(getPostTime());
			oneHourMore.add(Calendar.DAY_OF_YEAR, 1);
			if (new Date().after(oneHourMore.getTime())) { // т.е. проверяем его
															// рейтинг
				LeafDAO dao = new LeafDAO();
				try {
					double meanRating = 0;
					List<Leaf> list = dao.getTreeFromRoot(dao
							.get(getUpperLeafId()));
					for (Leaf leaf : list) {
						meanRating += leaf.getRating();
					}
					meanRating /= list.size();
					if (getRating() < meanRating / 2) // Когда рейтинг ние
														// среднего/2
														// тогда это не главный
														// пост
					{
						setMainMsg(false);
						return;
					}
				} finally {
					if (dao != null)
						dao.close();
				}

			}
		}
		setMainMsg(true);
	}

	public boolean getMainMsg() {
		return mainMsg;
	}

	public void setMainMsg(boolean mainMsg) {
		this.mainMsg = mainMsg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
