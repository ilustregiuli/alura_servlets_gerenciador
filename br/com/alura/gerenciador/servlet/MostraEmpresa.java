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


@WebServlet(name = "mostraEmpresa", urlPatterns = { "/mostraEmpresa" })
public class MostraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaId(id);
		System.out.println(empresa.getNome());
		
		// Após achar a empresa, vai colocar os dados dela "setando" os atributos da requisição 
		// com os dados da empresa buscada - 1 parametro : nome que vou dar ao dado para ser referenciado
		// na request, 2 parametro: o objeto
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
		rd.forward(request, response);
		
		
		
	}

}
