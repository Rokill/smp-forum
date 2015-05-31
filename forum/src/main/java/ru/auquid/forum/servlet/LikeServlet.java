package ru.auquid.forum.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.auquid.forum.beans.LikeBeanRemote;
import ru.auquid.forum.beans.UserBeanRemote;
import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.entity.Leaf;
import ru.auquid.forum.entity.helper.ForumUser;

/**
 * Servlet implementation class LikeServlet
 */
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private transient LikeBeanRemote like;

	@EJB
	private transient UserBeanRemote userBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LikeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		like.like(id);
		request.getSession().setAttribute(
				"user",
				new ForumUser(userBean.like((ForumUser) request.getSession()
						.getAttribute("user"))));
		response.sendRedirect("goto?id="
				+ request.getSession().getAttribute("rootId"));
	}
}
