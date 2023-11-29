package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MapController
 */
@WebServlet("/MapController")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MapController() {
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
		String sw2 = request.getParameter("sw2");
		
		if (sw2 == null) {
			sw2 = "myHome";
		}

		String latitude = "";
		String longitude = "";

		if (sw.equals("S1")) {
			if (sw2.equals("myHome")) {
				
				latitude = "37.54318902";
				longitude = "126.7278937";
				
			} else if (sw2.equals("academy")) {

				latitude = "37.48453469";
				longitude = "126.92992323";

			}
			request.setAttribute("latitude", latitude);
			request.setAttribute("longitude", longitude);

			RequestDispatcher rd = request.getRequestDispatcher("/map/map1.jsp");
			rd.forward(request, response);
		} else if (sw.equals("S3")) {
			
			String homeAddress = "인천광역시 계양구 어사대로 9번길 6";
			String homeStr = "우리집";
			
			request.setAttribute("homeAddress", homeAddress);
			request.setAttribute("homeStr", homeStr);
			
			RequestDispatcher rd = request.getRequestDispatcher("/map/map3.jsp");
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
