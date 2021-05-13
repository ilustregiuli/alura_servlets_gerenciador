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
		
		/* cria uma refer�ncia de RequestDispatcher que recebe um objeto
		 criado pelo m�todo "getReq..." de "request". Esse m�todo recebe
		 como par�metro o caminho para onde o objeto "rd" deve encaminhar	
		 as requisi��es	*/	
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresa.jsp"); 
		
		/* Associa � requisi��o aquilo que eu quero usar no JSP ("empresa")
		 * ".setAttribute" recebe dois par�metros: um nome String (apelido) e um Object
		 * Esse apelido � usado para referenciar l� no JSP
		 */
		request.setAttribute("emp", empresa);
		
		
		rd.forward(request, response);
		
		
	}

}
