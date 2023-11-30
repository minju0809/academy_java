package DBPKG;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.teacher.TeacherService;
import DBPKG.teacher.TeacherServiceImpl;
import DBPKG.teacher.TeacherVO;
import DBPKG.member.*;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
		
		TeacherService tescherService = new TeacherServiceImpl();
		MemberService memberService = new MemberServiceImpl();
		
		String sw = request.getParameter("sw");
		if (sw.equals("TeacherSelect")) {
			List<TeacherVO> li = tescherService.select();
			
			request.setAttribute("li", li);
			
			RequestDispatcher rd = request.getRequestDispatcher("/teacher_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("ClassInsert")) {
			
			String regist_month = request.getParameter("regist_month");
			String c_no = request.getParameter("c_no");
			String class_area = request.getParameter("address");
			int tuition = Integer.parseInt(request.getParameter("tuition")); 
			String teacher_code = request.getParameter("teacher_code");
			
			ClassVO vo = new ClassVO();
			
			vo.setRegist_month(regist_month);
			vo.setC_no(c_no);
			vo.setClass_area(class_area);
			vo.setTuition(tuition);
			vo.setTeacher_code(teacher_code);
			
			memberService.insert(vo);
			
			response.sendRedirect(path+"/index.jsp");
			
		} else if (sw.equals("MemberSelect")) {
			
			List<MemberVO> li = memberService.select();
			
			request.setAttribute("li", li);
			
			RequestDispatcher rd = request.getRequestDispatcher("/member_list.jsp");
			rd.forward(request, response);
			
			
		} else if (sw.equals("TeacherPriceSelect")) {
			List<TeacherVO> priceList = tescherService.priceSelect();
			
			request.setAttribute("priceList", priceList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/teacher_price_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("MemberInfoSelect")) {
			
			List<MemberVO> li = memberService.select();
			
			request.setAttribute("li", li);
			
			RequestDispatcher rd = request.getRequestDispatcher("/class_insert.jsp");
			rd.forward(request, response);
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
