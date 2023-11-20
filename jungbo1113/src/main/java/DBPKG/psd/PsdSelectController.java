package DBPKG.psd;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.multi.MultiButtonUI;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class PsdController
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

		String path = request.getContextPath();
		String sw = request.getParameter("sw");
		PsdService service = new PsdServiceImpl();
		PsdVO vo = null;

		if (sw.equals("I")) {
			String realFolder = "";
			String saveFolder = "/files";
			String encType = "utf-8";
			int maxSize = 5 * 1024 * 1024;

			ServletContext context = getServletContext();

			realFolder = context.getRealPath(saveFolder);

			System.out.println("realFolder: " + realFolder);
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());

			String fname = multi.getParameter("fname");
			String originalfimg = multi.getOriginalFileName("fimg");
			String fimg = multi.getFilesystemName("fimg");
			System.out.println("fname: " + fname);
			System.out.println("originalfimg: " + originalfimg);
			System.out.println("fimg: " + fimg);

			vo = new PsdVO();
			vo.setFname(fname);
			vo.setFimg(fimg);
			service.insert(vo);
			
			response.sendRedirect(path + "/PsdController?sw=S");

		} else if (sw.equals("S")) {
			List<PsdVO> li = service.select();
			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("/psd/psd_list.jsp");
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
