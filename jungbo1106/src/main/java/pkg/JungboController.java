package pkg;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

/**
 * Servlet implementation class JungboController
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String sw = request.getParameter("sw");
		JungService service = new JungServiceImpl();
		JungVO vo = new JungVO();

		if (sw.equals("F")) {
			int sNo = service.sNo();
			request.setAttribute("sNo", sNo); // "sNo"의 이름으로 sNo라는 객체를 담는다
			// dispatcher 의 url에 값을 넘겨야 할 때 사용

			RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("I")) {
			String sNo = request.getParameter("sNo");
			String sName = request.getParameter("sName");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			int hist = Integer.parseInt(request.getParameter("hist"));
			String today = request.getParameter("today");
			vo.setsNo(sNo);
			vo.setsName(sName);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setHist(hist);
			vo.setToday(today);
			service.insert(vo);

			response.sendRedirect("JungboController?sw=S"); // url을 JungboController?sw=S로 변경

//			RequestDispatcher dispatcher = request.getRequestDispatcher("JungboController?sw=S");
//			dispatcher.forward(request, response);
		} else if (sw.equals("S")) {
			List<JungVO> li = service.select();

			request.setAttribute("li", li);

			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
			
		} else if (sw.equals("E")) {
			String sNo = request.getParameter("sNo");
			int sNoK = Integer.parseInt(sNo);
			vo = service.edit(sNoK);
			service.cnt(sNo);

			request.setAttribute("vo", vo); // 해당 sNo의 vo를 넘김

			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("U")) {
			String sNo = request.getParameter("sNo");
			String sName = request.getParameter("sName");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			int hist = Integer.parseInt(request.getParameter("hist"));
			String today = request.getParameter("today");
			vo.setsNo(sNo);
			vo.setsName(sName);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setHist(hist);
			vo.setToday(today);

			service.update(vo);

			response.sendRedirect("JungboController?sw=S");

//			RequestDispatcher dispatcher = request.getRequestDispatcher("JungboController?sw=S");
//			dispatcher.forward(request, response);
		} else if (sw.equals("D")) {
			String sNo = request.getParameter("sNo");
			service.delete(sNo);

			response.sendRedirect("JungboController?sw=S");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("JungboController?sw=S");
//			dispatcher.forward(request, response);
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
