package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.basicBoard.*;

/**
 * Servlet implementation class BasicBoardController
 */
@WebServlet("/BasicBoardController")
public class BasicBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BasicBoardController() {
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

		String path = request.getContextPath();
		String sw = request.getParameter("sw");

		BoardService service = new BoardServiceImpl();
		
		BoardVO vo = new BoardVO();
		
		String idx = request.getParameter("idx");
		String sname = request.getParameter("sname");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		vo.setIdx(idx);
		vo.setSname(sname);
		vo.setTitle(title);
		vo.setContent(content);
		
		if (sw.equals("I")) {
			service.insert(vo);
			response.sendRedirect(path+"/BasicBoardController?sw=S");
		} else if (sw.equals("U")) {
			service.update(vo);
			response.sendRedirect(path+"/BasicBoardController?sw=S");
		} else if (sw.equals("D")) {
			service.insert(vo);
			response.sendRedirect(path+"/BasicBoardController?sw=S");
		} else if (sw.equals("S")) {
			request.setAttribute("li", service.list(vo));
			RequestDispatcher rd = request.getRequestDispatcher("/basicBoard/board_list.jsp");
			rd.forward(request, response);
		} else if (sw.equals("E")) {
			service.cntCount(vo);
			request.setAttribute("m", service.edit(vo));
			RequestDispatcher rd = request.getRequestDispatcher("/basicBoard/board_edit.jsp");
			rd.forward(request, response);
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
