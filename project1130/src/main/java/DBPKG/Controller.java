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
import DBPKG.comment.*;

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
		CommentService commentService = new CommentServiceImpl();
		
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
			String teacher_code = request.getParameter("class_name");
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
			
			RequestDispatcher rd = request.getRequestDispatcher("/member/member_list.jsp");
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
			
		} else if (sw.equals("ClassSelect")) {
			
			List<ClassVO> classList = memberService.classSelect();
			
			request.setAttribute("classList", classList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/class_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("MemberDetail")) {
			
			String c_no = request.getParameter("c_no");
			
			MemberVO m = memberService.detail(c_no);
			
			request.setAttribute("m", m);
			
			
			// 코맨트 select
			List<CommentVO> commentList = commentService.commentSelect(c_no);
			
			request.setAttribute("commentList", commentList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/member/member_detail.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("CommentInsert")) {
			String c_no = request.getParameter("c_no");
			String writer = request.getParameter("writer");
			String memo = request.getParameter("memo");
			
			CommentVO vo = new CommentVO();
			vo.setC_no(c_no);
			vo.setMemo(memo);
			vo.setWriter(writer);
			
			commentService.commentInsert(vo);
			
			response.sendRedirect(path+"/Controller?sw=MemberDetail&c_no=" + c_no);
			
		} else if (sw.equals("memoDelete")) {
			
			String c_no = request.getParameter("c_no");
			int idx = Integer.parseInt(request.getParameter("idx"));
			commentService.commentDelete(idx);
			
			response.sendRedirect(path+"/Controller?sw=MemberDetail&c_no=" + c_no);
			
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
