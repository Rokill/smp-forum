package ru.auquid.forum.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.auquid.forum.beans.BranchBean;
import ru.auquid.forum.beans.BranchBeanRemote;
import ru.auquid.forum.dao.LeafDAO;
import ru.auquid.forum.entity.Leaf;
import ru.auquid.forum.entity.User;
import ru.auquid.forum.util.BeansLocator;

/**
 * Servlet implementation class PostServlet
 */
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private transient BranchBeanRemote branch;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("message");
		String rootId = (String) request.getSession().getAttribute("rootId");
		if (request.getParameter("msg_but") != null) {
			branch.createMsgLeaf(msg, Integer.valueOf(rootId), ((User) request
					.getSession().getAttribute("user")));
			setParams(request, Integer.valueOf(rootId));
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
		if (request.getParameter("sub_br_but") != null) {
			if (request.getParameter("isLast") != null) {
				branch.createNewTheme(Integer.valueOf(rootId), msg,
						((User) request.getSession().getAttribute("user")));
			} else {
				branch.createSubBranch(Integer.valueOf(rootId), msg,
						((User) request.getSession().getAttribute("user")));
			}
			setParams(request, Integer.valueOf(rootId));
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

	private void setParams(HttpServletRequest request, Integer rootId) {
		LeafDAO dao = new LeafDAO();
		try {
			request.setAttribute("msg",
					dao.getRootList(dao.get(Integer.valueOf(rootId))));
			request.setAttribute("upperRootId",
					dao.get(dao.get(rootId).getUpperLeafId()));
		} finally {
			if (dao != null)
				dao.close();
		}

	}
}
