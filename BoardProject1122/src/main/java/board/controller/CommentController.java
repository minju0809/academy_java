package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.comment.BoardService;
import board.comment.BoardServiceImpl;
import board.comment.BoardVO;
import board.comment.CommentVO;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentController() {
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
		
		BoardVO vo = new BoardVO();
		
		String idx = request.getParameter("idx");
		String sname = request.getParameter("sname");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		vo.setIdx(idx);
		vo.setSname(sname);
		vo.setTitle(title);
		vo.setContent(content);
		
		CommentVO cvo = new CommentVO();
	
		String comment_idx = request.getParameter("comment_idx");
		String commentContent = request.getParameter("commentContent");
		cvo.setComment_idx(comment_idx);
		cvo.setCommentContent(commentContent);
		
		if (sw.equals("I")) {
			service.insert(vo);
			response.sendRedirect(path+"/CommentController?sw=S");
		} else if (sw.equals("CI")) {
			service.commentInsert(cvo);
			response.sendRedirect(path+"/CommentController?sw=E&idx="+comment_idx);
		} else if (sw.equals("U")) {
			service.update(vo);
			response.sendRedirect(path+"/CommentController?sw=S");
		} else if (sw.equals("D")) {
			service.delete(vo);
			response.sendRedirect(path+"/CommentController?sw=S");
		} else if (sw.equals("CD")) {
			cvo.setIdx(idx);
			service.commentDelete(cvo);
			response.sendRedirect(path+"/CommentController?sw=E&idx="+comment_idx);
		} else if (sw.equals("S")) {
			request.setAttribute("li", service.list(vo));
			RequestDispatcher rd = request.getRequestDispatcher("/commentBoard/board_list.jsp");
			rd.forward(request, response);
		} else if (sw.equals("E")) {
			cvo = new CommentVO();
			service.cntCount(vo);
			cvo.setIdx(idx);
			request.setAttribute("m", service.edit(vo));
			request.setAttribute("li", service.commentlist(cvo));
			RequestDispatcher rd = request.getRequestDispatcher("/commentBoard/board_edit.jsp");
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
