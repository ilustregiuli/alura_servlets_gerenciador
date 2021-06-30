package br.com.alura.gerenciador.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/meuServlet", loadOnStartup=1)
public class OiMundoServlet extends HttpServlet{
	
	public OiMundoServlet() {
		System.out.println("Oi mundo iniciado!");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Meu primeiro Servlet");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Deu certo!");
	}

}
