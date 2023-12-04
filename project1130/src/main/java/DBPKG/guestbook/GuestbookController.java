package DBPKG.guestbook;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestbookController
 */
@WebServlet("/GuestbookController")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sw = request.getParameter("sw");
		String path = request.getContextPath();
		
		GuestbookService service = new GuestbookServiceImpl();
		
		if (sw.equals("GuestbookSelect")) {
			
			String ch1 = request.getParameter("ch1");
			String ch2 = request.getParameter("ch2");
			
			int start = 0;
			int pageSize = 10;
			
			if (request.getParameter("start") == null) {
				start = 1;
			} else {
				start = Integer.parseInt(request.getParameter("start"));
			}
			
			GuestbookVO m = new GuestbookVO();
			
			m.setCh1(ch1);
			m.setCh2(ch2);
			m.setStart(start);
			m.setPageSize(pageSize);
			
			List<GuestbookVO> li = service.guestbookSelect(m);
			int totalCount = service.totalCount(m);
			
			request.setAttribute("li", li);
			request.setAttribute("totalCount", totalCount);
			
			request.setAttribute("ch1", ch1);
			request.setAttribute("ch2", ch2);
			
			request.setAttribute("start", start);
			request.setAttribute("pageSize", pageSize);
			
			RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guestbook_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("GuestbookInsertAll")) {
			
			service.guestbookInsertAll();
			
			response.sendRedirect(path + "/GuestbookController?sw=GuestbookSelect");
			 
		} else if (sw.equals("GuestbookDelete")) {
			
			int idx = Integer.parseInt(request.getParameter("idx"));
			String ch1 = request.getParameter("ch1");
			String ch2 = URLEncoder.encode(request.getParameter("ch2"), "utf-8");
			
			service.guestbookDelete(idx);
			
			response.sendRedirect(path + "/GuestbookController?sw=GuestbookSelect&idx="+idx+"&ch1="+ch1+"&ch2="+ch2);
			
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
