package pkg.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pkg.model.MemberVO;
import pkg.service.MemberService;
import pkg.service.MemberServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class JoinController
 */
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("==> Controller 확인");

		// 방법 1. Redirect
//		String path = request.getContextPath();
//		response.sendRedirect(path + "/member/member_list.jsp");

		// 방법 2. Foward (select 쿼리)
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/member_list.jsp");
//		dispatcher.forward(request, response);

		MemberService service = null;
		RequestDispatcher dispatcher = null;
		MemberVO vo = null;
		String id = null;
		String select = request.getParameter("select");
		switch (select) {
		case "s":
			service = new MemberServiceImpl();
			List<MemberVO> li = service.select(null);
			request.setAttribute("li", li); // service에서 값을 가져올 때, 받아온 li 값을 request 객체에 담아두기

			dispatcher = request.getRequestDispatcher("/member/member_list.jsp");
			dispatcher.forward(request, response);
			break;
		case "i":
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			service = new MemberServiceImpl();
			vo = new MemberVO();
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			service.insert(vo);

			// 목록을 바로 보려면 member_list.jsp로 가는 것이 아니고 SelectController로 가야함
			dispatcher = request.getRequestDispatcher("/member/member_result.jsp");
			dispatcher.forward(request, response);
			break;
		case "e":
			id = request.getParameter("id");
			service = new MemberServiceImpl();
			vo = new MemberVO();
			vo.setId(id);

			MemberVO m = service.edit(vo);
			request.setAttribute("m", m); // service에서 값을 가져올 때, 받아온 li 값을 request 객체에 담아두기

			dispatcher = request.getRequestDispatcher("/member/member_edit.jsp");
			dispatcher.forward(request, response);
			break;
		case "d":
			id = request.getParameter("id");
			service = new MemberServiceImpl();
			service.delete(id);

			dispatcher = request.getRequestDispatcher("/JoinController?select=s");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
