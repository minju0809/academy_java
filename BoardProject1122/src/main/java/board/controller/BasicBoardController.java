
package board.controller;

import java.awt.color.ColorSpace;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

		String realF = getServletContext().getRealPath("basicBoard/files/");
		int maxS = 1024 * 1024 * 5;
		String encT = "UTF-8";
		
		String idx = request.getParameter("idx");
		String sname = request.getParameter("sname");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String img = request.getParameter("img");
		vo.setIdx(idx);
		vo.setSname(sname);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setImg(img);

		if (sw.equals("I")) {

			DefaultFileRenamePolicy DefaultF = new DefaultFileRenamePolicy();

			MultipartRequest multi = new MultipartRequest(request, realF, maxS, encT, DefaultF);

			sname = multi.getParameter("sname");
			title = multi.getParameter("title");
			content = multi.getParameter("content");

			img = multi.getFilesystemName("img");

			if (img == null) {
				img = "space.png";
			}
			vo.setSname(sname);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setImg(img);

			service.insert(vo);
			response.sendRedirect(path + "/BasicBoardController?sw=S");
			
		} else if (sw.equals("U")) {
			
	        DefaultFileRenamePolicy DefaultF = new DefaultFileRenamePolicy();
	        MultipartRequest multi = new MultipartRequest(request, realF, maxS, encT, DefaultF);

	        idx = multi.getParameter("idx");
	        sname = multi.getParameter("sname");
	        title = multi.getParameter("title");
	        content = multi.getParameter("content");
	        img = multi.getFilesystemName("img");
	        
	        if(img == null) img = "space.png";
	        
			vo.setIdx(idx);
			vo.setSname(sname);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setImg(img);
			
			BoardVO m = service.edit(vo);
			String delImg = m.getImg();
			
	        String delFile = realF + delImg;
	        
			System.out.println("수정 시 삭제 할 파일경로와 이름: " + delFile);
			File file = new File(delFile);
			
			if (!delImg.equals("space.png")) {
				file.delete();
			}
			
			service.update(vo);
			
			response.sendRedirect(path + "/BasicBoardController?sw=S");
			
		} else if (sw.equals("D")) {

			// 파일 삭제
			String delFile = realF + img;
			System.out.println("삭제할 파일경로와 이름: " + delFile);
			File file = new File(delFile);
			
			if(file.exists()) {
				if(!img.equals("space.png")) {
					file.delete();
				}
			}
			
			service.delete(vo);
			response.sendRedirect(path + "/BasicBoardController?sw=S");
			
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
