package ru.auquid.forum.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.auquid.forum.beans.BranchBeanRemote;
import ru.auquid.forum.beans.UserBeanRemote;
import ru.auquid.forum.entity.User;
import ru.auquid.forum.entity.helper.ForumUser;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private transient UserBeanRemote userBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("reg.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String pass = request.getParameter("password");
		User user = userBean.registrate(name,pass);
		if (user != null)
		{
			request.getSession().setAttribute("user", new ForumUser(user));
			request.getRequestDispatcher("logged.jsp").forward(request,
					response);
		}
		else
		{
			request.setAttribute("error", "exist");
			request.getRequestDispatcher("reg.jsp").forward(request,
					response);
		}
	}

}
