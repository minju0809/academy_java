package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.pageBoard1.BoardService;
import board.pageBoard1.BoardServiceImpl;
import board.pageBoard1.BoardVO;

/**
 * Servlet implementation class PageBoardController
 */
@WebServlet("/PageBoardController")
public class PageBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageBoardController() {
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
		
		BoardService service = new BoardServiceImpl();
		
		BoardVO vo = null;
		
		if (sw.equals("big")) {
			
			service.bigInsert(null);
			
			response.sendRedirect(path + "/index.jsp");
			
		} else if (sw.equals("S")) {
			vo = new BoardVO();

			// 검색
			String ch1 = request.getParameter("ch1");
			String ch2 = request.getParameter("ch2");
			vo.setCh1(ch1);
			vo.setCh2(ch2);
			
			// 페이지 나누기
			String start = request.getParameter("start");
			int pageSize = 10;
			
			int startIdx = 0;
			int tc = service.totalCount(vo);
			int totalPage = (int) Math.ceil((double)tc/pageSize); 
			
			if (start == null) {
				startIdx = 1;
			} else {
				startIdx = Integer.parseInt(start);
			}
			
			int currentPage = (startIdx/pageSize) + 1;
			
			vo.setPageSize(pageSize);
			vo.setStart(startIdx);
			
			List<BoardVO> li = service.select(vo);
			request.setAttribute("li", li);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("start", startIdx);
			request.setAttribute("tc", tc);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("ch1", ch1);
			request.setAttribute("ch2", ch2);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pageBoard1/board_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("E")) {
			
			BoardVO m = service.edit(null);
			request.setAttribute("m", m);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pageBoard1/board_edit.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("D")) {
			vo = new BoardVO();
			
			String idx = request.getParameter("idx");
			vo.setIdx(idx);
			
			service.delete(idx);
			
			response.sendRedirect("PageBoardController?sw=S");
			
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
