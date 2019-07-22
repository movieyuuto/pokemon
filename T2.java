package pokemon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/T2")
public class T2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public T2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		T2DAO t2dao = new T2DAO();
		session.setAttribute("all", t2dao.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pokemon/t2.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action.equals("create")) {
			String number = request.getParameter("number");
			String name = request.getParameter("name");
			String attack = request.getParameter("attack");
			System.out.printf("%s %s %s\n", number, name, attack);
			T2DAO t2dao = new T2DAO();
			boolean success = t2dao.create(Integer.parseInt(number), name, Integer.parseInt(attack));
			if (success) {
				session.setAttribute("message", "create成功");
			} else {
				session.setAttribute("message", "create失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pokemon/t2result.jsp");
			dispatcher.forward(request, response);
		} else if (action.contentEquals("delete")) {
			String number = request.getParameter("number");
			T2DAO t2dao = new T2DAO();
			boolean success = t2dao.delete(Integer.parseInt(number));
			System.out.println(1);
			if (success) {
				session.setAttribute("message", "delete成功");
			} else {
				session.setAttribute("message", "delete失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pokemon/t2result.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("update")) {
			String number = request.getParameter("number");
			String name = request.getParameter("name");
			String attack = request.getParameter("attack");
			System.out.printf("%s %s %s\n", number, name, attack);
			T2DAO t2dao = new T2DAO();
			if(number == "")
			{
				number ="0";
			}
			if(name == "")
			{
				name ="null";
			}
			if(attack == "")
			{
				attack = "0";
			}
			boolean success = t2dao.update(name, Integer.parseInt(attack),Integer.parseInt(number));
			if (success) {
				session.setAttribute("message", "update成功");
			} else {
				session.setAttribute("message", "update失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pokemon/t2result.jsp");
			dispatcher.forward(request, response);
		}
	}
}
