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

	// M�todo alterado para "service" em vez de "doGet", pois a requisi��o que v�m � "post"
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
