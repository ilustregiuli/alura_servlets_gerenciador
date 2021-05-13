package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa.");
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		// chamar o JSP
		
		/* cria uma referência de RequestDispatcher que recebe um objeto
		 criado pelo método "getReq..." de "request". Esse método recebe
		 como parâmetro o caminho para onde o objeto "rd" deve encaminhar	
		 as requisições	*/	
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresa.jsp"); 
		
		/* Associa à requisição aquilo que eu quero usar no JSP ("empresa")
		 * ".setAttribute" recebe dois parâmetros: um nome String (apelido) e um Object
		 * Esse apelido é usado para referenciar lá no JSP
		 */
		request.setAttribute("emp", empresa);
		
		
		rd.forward(request, response);
		
		
	}

}
