package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "listaEmpresa", urlPatterns = { "/listaEmpresa" })
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Método alterado para "service" em vez de "doGet", pois a requisição que vêm é "post"
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		for(Empresa empresa : banco.getEmpresa()) { // mostra no servidor
			System.out.println(empresa.getNome());
		}
		List<Empresa> lista = banco.getEmpresa();
		
		
		request.setAttribute("empresas",lista); // envio da lista para JSP "Lista Empresa", atributo "empresas"
		
		System.out.println("Passou pela Lista Empresa Servlet");
		System.out.println("Vai para: Lista Empresa JSP");
		RequestDispatcher rd = request.getRequestDispatcher("/ListaEmpresa.jsp");
		rd.forward(request, response);
		
		
		
	}

}
