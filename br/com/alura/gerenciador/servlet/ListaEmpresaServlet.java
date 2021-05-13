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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		for(Empresa empresa : banco.getEmpresa()) {
			System.out.println(empresa.getNome());
		}
		List<Empresa> lista = banco.getEmpresa();
		
		
		request.setAttribute("empresas",lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListaEmpresa.jsp");
		rd.forward(request, response);
		
		
		
	}

}
