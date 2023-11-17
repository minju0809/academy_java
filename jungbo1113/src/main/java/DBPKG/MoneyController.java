package DBPKG;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.jungbo.JungboService;
import DBPKG.jungbo.JungboServiceImpl;

/**
 * Servlet implementation class MoneyController
 */
@WebServlet("/MoneyController")
public class MoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyController() {
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
		JungboService service0 = new JungboServiceImpl();
		MoneyService service = new MoneyServiceImpl();

		MoneyVO vo = new MoneyVO(); // insert

		if (sw.equals("M")) {
			List<MoneyVO> li = service.money("list");

			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("money.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("F")) {

			List<MemberVO> li = service0.select(null);
			request.setAttribute("li", li);
			
			int salenol = service.salenol();
			request.setAttribute("salenol", salenol);
			
			RequestDispatcher rd = request.getRequestDispatcher("money_form.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("I")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			int salenol = Integer.parseInt(request.getParameter("salenol"));
			int pcost = Integer.parseInt(request.getParameter("pcost"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int price = Integer.parseInt(request.getParameter("price"));
			String pcode = request.getParameter("pcode");
			Date sdate = Date.valueOf(request.getParameter("sdate"));
			vo.setCustno(custno);
			vo.setSalenol(salenol);
			vo.setPcost(pcost);
			vo.setAmount(amount);
			vo.setPrice(price);
			vo.setPcode(pcode);
			vo.setsDate(sdate);
			
			System.out.println("==> [moneyInsert] " + vo);

			service.moneyInsert(vo);

			response.sendRedirect(path + "/MoneyController?sw=F");
			
		} else if (sw.equals("S")) {
			List<MoneyVO> li = service.moneySelect(null);
			request.setAttribute("li", li);
			
			List<Integer> selectCustno = service.getMoneySelectCustno();
			request.setAttribute("selectCustno", selectCustno);

			RequestDispatcher rd = request.getRequestDispatcher("money_list.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("DayS")) { 
			List<MoneyVO> li = service.dayMoneySelect(vo);
			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("money_list_date.jsp");
			rd.forward(request, response);
		} else if (sw.equals("ML1")) {
			List<MoneyVO> li = service.money("graph");
			
			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("money_list1.jsp");
			rd.forward(request, response);
			
		} else if (sw.equals("ML2")) {
			List<MoneyVO> li = service.money("graph");
			
			request.setAttribute("li", li);

			RequestDispatcher rd = request.getRequestDispatcher("money_list2.jsp");
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
