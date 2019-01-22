package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

public class TestScopeServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		ServletContext ctx = super.getServletContext();
		String encoding = ctx.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		//在request作用域中添加一个对象
		req.setAttribute("user", new User("fanlanlan","666"));
		//forward跳转方式
		RequestDispatcher dsp = req.getRequestDispatcher("/TestScope.jsp");
		dsp.forward(req, resp);
	}
}
