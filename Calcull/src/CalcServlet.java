import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		int res = 0;
		int a = Integer.parseInt((String)req.getParameter("aNum"));
		int b = Integer.parseInt((String)req.getParameter("bNum"));
		String oper = (String) req.getParameter("oper");
		switch(oper)
		{
			case "-": res = a - b; break;
			case "+": res = a + b; break;
			case "*": res = a * b; break;
			case "/": res = a / b; break;
			default: break;
		}
		resp.getWriter().println(res);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req, resp);
	}
}
