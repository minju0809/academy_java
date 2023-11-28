package board.controller;

import java.io.IOException;
import java.net.URLEncoder;
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getContextPath();
		String sw = request.getParameter("sw");
		
		BoardService service = new BoardServiceImpl();
		
		BoardVO vo = new BoardVO();
		
		String ch1 = request.getParameter("ch1");
		String ch2 = request.getParameter("ch2");
		
		if (sw.equals("big")) {
			
			service.bigInsert(null);
			
			response.sendRedirect(path + "/index.jsp");
			
		} else if (sw.equals("S")) {
			
			// 검색
//			ch1 = request.getParameter("ch1");
//			ch2 = request.getParameter("ch2");
			vo.setCh1(ch1);
			vo.setCh2(ch2);
			
			// 페이지 나누기
			String start = request.getParameter("start");
			int pageSize = 10;
			int pageListSize = 10;
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
			request.setAttribute("pageListSize", pageListSize);
			request.setAttribute("start", startIdx);
			request.setAttribute("tc", tc);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("ch1", ch1);
			request.setAttribute("ch2", ch2);
			
			System.out.println("ch1: " + ch1 + "ch2: " + ch2 + "start: " + start);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pageBoard1/board_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("E")) {
			int start = Integer.parseInt(request.getParameter("start"));
			
			vo.setCh1(ch1);
			vo.setCh2(ch2);
			vo.setStart(start);

			String idx = request.getParameter("idx");
			BoardVO m = service.edit(idx);
			
			request.setAttribute("m", m);
			m.setCh1(ch1);
			m.setCh2(ch2);
			m.setStart(start);
			
			RequestDispatcher rd = request.getRequestDispatcher("/pageBoard1/board_edit.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("D")) {
			vo = new BoardVO();
			
			ch1 = request.getParameter("ch1");
			
			ch2 = URLEncoder.encode(request.getParameter("ch2"), "utf-8"); // 한글처리 
			
			String startStr = request.getParameter("start");
			int start = 1;
			if (startStr != null) {
				start = Integer.parseInt(startStr);
			}
			
			String idx = request.getParameter("idx");
			vo.setIdx(idx);
			
			service.delete(idx);
			
			response.sendRedirect("PageBoardController?sw=S&start="+start+"&ch1="+ch1+"&ch2="+ch2);
			
		} else if (sw.equals("U")) {
			
			ch1 = request.getParameter("ch1");
			
			ch2 = URLEncoder.encode(request.getParameter("ch2"), "utf-8"); // 한글처리 
			String startStr = request.getParameter("start");
			int start = 1;
			if (startStr != null) {
				start = Integer.parseInt(startStr);
			}
			
			String idx = request.getParameter("idx"); 
			String sname = request.getParameter("sname");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			vo = new BoardVO();

			vo.setIdx(idx);
			vo.setSname(sname);
			vo.setTitle(title);
			vo.setContent(content);
			
			service.update(vo);
			
			response.sendRedirect("PageBoardController?sw=S&start="+start+"&ch1="+ch1+"&ch2="+ch2);
			
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
