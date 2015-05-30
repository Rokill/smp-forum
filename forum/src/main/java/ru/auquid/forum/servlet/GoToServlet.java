package ru.auquid.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.entity.User;

/**
 * Servlet implementation class GoToServlet
 */
public class GoToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoToServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LeafDAO dao = null;
		try {
			dao = new LeafDAO();
			request.setAttribute("msg", dao.getTreeFromRoot(dao.get(Integer
					.valueOf(request.getParameter("id")))));
			request.getSession().setAttribute("rootId",
					request.getParameter("id"));
			request.setAttribute("upperRootId", dao.get(dao.get(
					Integer.valueOf(request.getParameter("id")))
					.getUpperLeafId()));
			if (!dao.isLastRoot(dao.get(Integer.valueOf(request
					.getParameter("id"))))) {
				request.setAttribute("msg", dao.getRootList(dao.get(Integer
						.valueOf(request.getParameter("id")))));
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			} else {
				request.getRequestDispatcher("msg.jsp").forward(request,
						response);
			}
		} finally {
			if (dao != null)
				dao.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
