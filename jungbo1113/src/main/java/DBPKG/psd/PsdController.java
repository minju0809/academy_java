package DBPKG.psd;

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

/**
 * Servlet implementation class PsdIUDController
 */
@WebServlet("/PsdController")
public class PsdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PsdController() {
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
		String path = request.getContextPath();

		System.out.println("PsdController: " + sw);

		String realF = getServletContext().getRealPath("/files/");
		int maxS = 5 * 1024 * 1024;
		String encT = "utf-8";

		PsdService service = new PsdServiceImpl();
		String idx, title, fname, etc, fimg;
		int age;
		PsdVO vo = null;

		if (sw.equals("S")) {
			String ch1 = request.getParameter("ch1");
			String ch2 = request.getParameter("ch2");

			vo = new PsdVO();
			vo.setCh1(ch1);
			vo.setCh2(ch2);

			List<PsdVO> li = service.select(vo);

			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("/psd/psd_list.jsp");
			rd.forward(request, response);

		} else if (sw.equals("E")) {
			idx = request.getParameter("idx");
			PsdVO m = service.edit(Integer.parseInt(idx));

			request.setAttribute("m", m);

			RequestDispatcher rd = request.getRequestDispatcher("/psd/psd_edit.jsp");
			rd.forward(request, response);	
			
		} else if (sw.equals("I")) {
			MultipartRequest multi = new MultipartRequest(request, realF, maxS, encT, new DefaultFileRenamePolicy());

			title = multi.getParameter("title");
			fname = multi.getParameter("fname");
			fimg = multi.getFilesystemName("fimg");
			age = Integer.parseInt(multi.getParameter("age"));
			etc = multi.getParameter("etc");

			if (fimg == null) {
				fimg = "space.png";
			}

			vo = new PsdVO();
			vo.setTitle(title);
			vo.setFname(fname);
			vo.setFimg(fimg);
			vo.setAge(age);
			vo.setEtc(etc);
			vo.setFimg(fimg);

			service.insert(vo);

			response.sendRedirect(path + "/PsdController?sw=S");

		} else if (sw.equals("D")) {
			idx = request.getParameter("idx");
			fimg = service.selectFileName(Integer.parseInt(idx));
			System.out.println("삭제 파일 명: " + fimg);

			String delFile = realF + fimg;
			File f = new File(delFile);

			if (f.exists()) {
				if (!fimg.equals("space.png")) {
					f.delete();
				}
			}
			
	        vo = new PsdVO();
	        vo.setIdx(Integer.parseInt(idx));

			service.delete(Integer.parseInt(idx));

			response.sendRedirect("PsdController?sw=S");

		} else if (sw.equals("U")) {
			DefaultFileRenamePolicy DefaultF = new DefaultFileRenamePolicy();

			MultipartRequest multi = new MultipartRequest(request, realF, maxS, encT, DefaultF);

			idx = multi.getParameter("idx");
			fimg = service.selectFileName(Integer.parseInt(idx));

			title = multi.getParameter("title");
			fname = multi.getParameter("fname");
			fimg = multi.getFilesystemName("fimg");
			age = Integer.parseInt(multi.getParameter("age"));
			etc = multi.getParameter("etc");
			int idx2 = Integer.parseInt(multi.getParameter("idx"));

			vo = new PsdVO();
			vo.setIdx(idx2);
			vo.setTitle(title);
			vo.setFname(fname);
			vo.setFimg(fimg);
			vo.setAge(age);
			vo.setEtc(etc);

			service.update(vo);

			response.sendRedirect(path + "/PsdController?sw=S");
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
