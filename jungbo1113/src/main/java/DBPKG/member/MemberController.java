package DBPKG.member;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBPKG.member.MemberVO;
import DBPKG.money.*;

/**
 * Servlet implementation class JungboController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int custno;
		String custname;
		String phone;
		String address;
		Date joindate;
		String grade;
		String city;
		String pwd;

		String sw = request.getParameter("sw");
		MemberService jungboService = new MemberServiceImpl();
		MoneyService moneyService = new MoneyServiceImpl();
		MemberVO memberVO = null;

		if (sw.equals("S")) {
			List<MemberVO> list = jungboService.select(null);
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/member_list.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("F")) {
			int maxCustno = jungboService.maxCustno();
			request.setAttribute("maxCustno", maxCustno);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member_form.jsp");
			dispatcher.forward(request, response);

		} else if (sw.equals("I")) {
			custno = Integer.parseInt(request.getParameter("custno"));
			custname = request.getParameter("custname");
			pwd = request.getParameter("pwd");
			phone = request.getParameter("phone");
			address = request.getParameter("address");
			joindate = Date.valueOf(request.getParameter("joindate"));
			grade = request.getParameter("grade");
			city = request.getParameter("city");
			
			memberVO = new MemberVO();
			memberVO.setCustno(custno);
			memberVO.setCustname(custname);
			memberVO.setPwd(pwd);
			memberVO.setPhone(phone);
			memberVO.setAddress(address);
			memberVO.setJoindate(joindate);
			memberVO.setGrade(grade);
			memberVO.setCity(city);
			jungboService.insert(memberVO);
			response.sendRedirect("./MemberController?sw=S");
			
		} else if (sw.equals("E")) {
			custno = Integer.parseInt(request.getParameter("custno"));
			memberVO = jungboService.selectCustno(custno);
			request.setAttribute("vo", memberVO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member_edit.jsp");
			dispatcher.forward(request, response);

		} else if (sw.equals("D")) {
			custno = Integer.parseInt(request.getParameter("custno"));
			jungboService.delete(custno);
			response.sendRedirect("./MemberController?sw=S");
		} else if (sw.equals("U")) {
			custno = Integer.parseInt(request.getParameter("custno"));
			custname = request.getParameter("custname");
			pwd = request.getParameter("pwd");
			phone = request.getParameter("phone");
			address = request.getParameter("address");
			joindate = Date.valueOf(request.getParameter("joindate"));
			grade = request.getParameter("grade");
			city = request.getParameter("city");

			memberVO = new MemberVO();
			memberVO.setCustno(custno);
			memberVO.setCustname(custname);
			memberVO.setPwd(pwd);
			memberVO.setPhone(phone);
			memberVO.setAddress(address);
			memberVO.setJoindate(joindate);
			memberVO.setGrade(grade);
			memberVO.setCity(city);
			jungboService.update(memberVO);

			response.sendRedirect("./MemberController?sw=S");
		} else if (sw.equals("M")) {
			List<MoneyVO> list = moneyService.getMoney("sumMoney");
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/money.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("ML1")) {
			List<MoneyVO> list = moneyService.getMoney("custno");
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/money_list_gragh1.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("ML2")) {
			List<MoneyVO> list = moneyService.getMoney("sumMoney");
			request.setAttribute("list", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/money_list_gragh2.jsp");
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
