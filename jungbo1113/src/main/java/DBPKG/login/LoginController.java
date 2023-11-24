<<<<<<< HEAD
package DBPKG.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String path = request.getContextPath();
		String sw = request.getParameter("sw");
		
		HttpSession session = request.getSession();

		LoginService service = new LoginServiceImpl();

		if (sw.equals("login")) {
			response.sendRedirect(path+"/login/login.jsp");
		} else if (sw.equals("loginOK")) {
			String custname = request.getParameter("custname");
			String pwd = request.getParameter("pwd");
			LoginVO vo = new LoginVO();
			
			vo.setCustname(custname);
			vo.setPwd(pwd);
			String str = service.login(vo);
			System.out.println("@@@@@@@@@@" + str);
			
			if (str.equals("F")) {
				session.setAttribute("id", null);
				response.sendRedirect(path+"/login/login.jsp");
			} else {
				session.setAttribute("id", custname);
				session.setAttribute("id2", str);
				response.sendRedirect(path+"/index.jsp");
			}
		} else if (sw.equals("logout")) {
			session.invalidate();
			response.sendRedirect(path+"/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
package DBPKG.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String path = request.getContextPath();
		String sw = request.getParameter("sw");
		
		HttpSession session = request.getSession();

		LoginService service = new LoginServiceImpl();

		if (sw.equals("login")) {
			response.sendRedirect(path+"/login/login.jsp");
		} else if (sw.equals("loginOK")) {
			String custname = request.getParameter("custname");
			String pwd = request.getParameter("pwd");
			LoginVO vo = new LoginVO();
			
			vo.setCustname(custname);
			vo.setPwd(pwd);
			String str = service.login(vo);
			System.out.println("@@@@@@@@@@" + str);
			
			if (str.equals("F")) {
				session.setAttribute("id", null);
				response.sendRedirect(path+"/login/login.jsp");
			} else {
				session.setAttribute("id", custname);
				session.setAttribute("id2", str);
				response.sendRedirect(path+"/index.jsp");
			}
		} else if (sw.equals("logout")) {
			session.invalidate();
			response.sendRedirect(path+"/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
>>>>>>> 37c817c84e9ceefc2fab1390af0949fde27c29fe
