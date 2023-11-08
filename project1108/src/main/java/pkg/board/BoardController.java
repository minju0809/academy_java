package pkg.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
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

		if (sw.equals("S")) {
			System.out.println("BoardController S 확인");

			String ch1 = request.getParameter("ch1");
			String ch2 = request.getParameter("ch2");
			vo.setCh1(ch1);
			vo.setCh2(ch2);

			List<BoardVO> li = service.select(vo);
			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("/board/board_list.jsp");
			rd.forward(request, response);

		} else if (sw.equals("I")) {
			System.out.println("BoardController I 확인");

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			vo.setTitle(title);
			vo.setContent(content);
			service.insert(vo);

			response.sendRedirect(path + "/BoardController?sw=S");
		} else if (sw.equals("E")) {

			int num_id = Integer.parseInt(request.getParameter("num_id"));
			vo.setNum_id(num_id);
			BoardVO m = service.edit(vo);
//			System.out.println("BoardVO m : " + m);
			request.setAttribute("m", m);

			RequestDispatcher rd = request.getRequestDispatcher("/board/board_edit.jsp");
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
