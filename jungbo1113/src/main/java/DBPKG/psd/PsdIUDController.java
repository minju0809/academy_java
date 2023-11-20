package DBPKG.psd;

import java.io.File;
import java.io.IOException;
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
@WebServlet("/PsdIUDController")
public class PsdIUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PsdIUDController() {
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
		System.out.println("PsdIUDController: " + sw);
		PsdService service = new PsdServiceImpl();

		String realF = getServletContext().getRealPath("/files/");
		int maxS = 5 * 1024 * 1024;
		String encT = "utf-8";


		PsdVO vo = null;
		if (sw.equals("I")) {
			MultipartRequest multi = 
					new MultipartRequest(request, realF, maxS, encT, new DefaultFileRenamePolicy());
			
			String title = multi.getParameter("title");
			String fname = multi.getParameter("fname");
			String fimg = multi.getFilesystemName("fimg");
			String age = multi.getParameter("age");
			String etc = multi.getParameter("etc");

			vo = new PsdVO();
			vo.setTitle(title);
			vo.setFname(fname);
			vo.setFimg(fimg);
			vo.setAge(Integer.parseInt(age));
			vo.setEtc(etc);

			service.insert(vo);
			
			response.sendRedirect("PsdSelectController?sw=S");

		} else if (sw.equals("D")) {
			String idx = request.getParameter("idx");
			String fimg = service.selectFileName(Integer.parseInt(idx));
			System.out.println("삭제 파일 명: " + fimg);
			
			String delFile = realF + fimg;
			File f = new File(delFile);
			
			if (f.exists()) {
				if (!fimg.equals("space.png")) {
					f.delete();
				}
			}
			service.delete(Integer.parseInt(idx));
			
			response.sendRedirect("PsdSelectController?sw=S");
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
