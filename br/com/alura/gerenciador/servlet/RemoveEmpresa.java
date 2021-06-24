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


@WebServlet(name = "removeEmpresa", urlPatterns = { "/removeEmpresa" })
public class RemoveEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Método alterado para "service" em vez de "doGet", pois a requisição que vêm é "post"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recebe aqui a requisição do navegador
		// pegar a empresa onde foi clicada o "remover"
		// vai usar o ID da empresa para fazer a exclusão
		
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.remove(id);
		
		response.sendRedirect("listaEmpresa");
		
	}

}
