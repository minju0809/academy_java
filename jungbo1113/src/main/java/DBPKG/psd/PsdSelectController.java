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
import javax.servlet.http.HttpSession;
import javax.swing.plaf.multi.MultiButtonUI;

import org.apache.coyote.Request;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DBPKG.psd.PsdVO;

/**
 * Servlet implementation class PsdController
 */
@WebServlet("/PsdSelectController")
public class PsdSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PsdSelectController() {
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

		System.out.println("PsdSelectController");
		
		PsdService service = new PsdServiceImpl();
//		HttpSession session = request.getSession();

		String sw = request.getParameter("sw");
		if (sw.equals("S")) {

			List<PsdVO> li = service.select();

			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("/psd/psd_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("E")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			PsdVO m = service.edit(idx);
			
			request.setAttribute("m", m);
			System.out.println("@@@@@@@m: " +m);

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
