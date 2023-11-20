package DBPKG.jungbo;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBPKG.MemberVO;

/**
 * Servlet implementation class JungboController
 */
@WebServlet("/JungboController")
public class JungboController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JungboController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ''' 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String path = request.getContextPath();

		String sw = request.getParameter("sw");
		JungboService service = new JungboServiceImpl();

		MemberVO vo = new MemberVO(); // insert
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionID", "young");

		if (sw.equals("S")) {
			List<MemberVO> li = service.select(null);

			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("member_list.jsp");
			rd.forward(request, response);
		} else if (sw.equals("F")) {
			int custno = service.custno();
			request.setAttribute("custno", custno);

			RequestDispatcher rd = request.getRequestDispatcher("member_form.jsp");
			rd.forward(request, response);
		} else if (sw.equals("I")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Date joindate = Date.valueOf(request.getParameter("joindate"));
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			vo.setCustno(custno);
			vo.setCustname(custname);
			vo.setPhone(phone);
			vo.setAddress(address);
			vo.setJoindate(joindate);
			vo.setGrade(grade);
			vo.setCity(city);
			
			System.out.println("==> [insert] " + vo);

			service.insert(vo);

			response.sendRedirect(path + "/JungboController?sw=F");
		} else if (sw.equals("D")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			vo.setCustno(custno);

			service.delete(vo);

			RequestDispatcher rd = request.getRequestDispatcher("/JungboController?sw=S");
			rd.forward(request, response);
		} else if (sw.equals("E")) {
			int custno = Integer.parseInt(request.getParameter("custno"));

			MemberVO m = service.edit(custno);

			request.setAttribute("m", m);
			
			RequestDispatcher rd = request.getRequestDispatcher("/member_edit.jsp");
			rd.forward(request, response);
		} else if (sw.equals("U")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Date joindate = Date.valueOf(request.getParameter("joindate"));
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			vo.setCustno(custno);
			vo.setCustname(custname);
			vo.setPhone(phone);
			vo.setAddress(address);
			vo.setJoindate(joindate);
			vo.setGrade(grade);
			vo.setCity(city);
			
			service.update(vo);

			response.sendRedirect(path + "/JungboController?sw=F");
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
