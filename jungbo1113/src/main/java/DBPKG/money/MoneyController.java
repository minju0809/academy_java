
package DBPKG.money;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBPKG.member.*;

/**
 * Servlet implementation class MemberController
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
		String sw = request.getParameter("sw");
		MemberService jungboService = new MemberServiceImpl();
		MoneyService moneyService = new MoneyServiceImpl();
		if(sw.equals("MF")){
			List<MemberVO> list = jungboService.select(null);
			request.setAttribute("list", list);
			int maxSalenol = moneyService.maxSalenol();
			request.setAttribute("maxSalenol", maxSalenol);
			
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("/money_form.jsp");
		 	dispatcher.forward(request, response);
		}else if(sw.equals("I")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			int salenol = Integer.parseInt(request.getParameter("salenol"));
			int pcost = Integer.parseInt(request.getParameter("pcost"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int price = Integer.parseInt(request.getParameter("price"));
			String pcode = request.getParameter("pcode");
			Date sdate = Date.valueOf(request.getParameter("sdate"));
			MoneyVO moneyVO = new MoneyVO();
			moneyVO.setCustno(custno);
			moneyVO.setSalenol(salenol);
			moneyVO.setPcost(pcost);
			moneyVO.setAmount(amount);
			moneyVO.setPrice(price);
			moneyVO.setPcode(pcode);
			moneyVO.setSdate(sdate);
			moneyService.insert(moneyVO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MemberController?sw=M");
		 	dispatcher.forward(request, response);
		}else if(sw.equals("DateList")) {
			List<MoneyVO> list = moneyService.getMoneySdate();
			request.setAttribute("list", list);
			
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("/money_list.jsp");
		 	dispatcher.forward(request, response);
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
