package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "alteraEmpresa", urlPatterns = { "/alteraEmpresa" })
public class AlteraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Método alterado para "service" em vez de "doGet", pois a requisição que vêm é "post"
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chegou aqui! Alterar");
		// recebe aqui a requisição do navegador
		// pegar a empresa onde foi clicada o "alterar"
		// vai usar o ID da empresa para fazer a alteração
		
		String nomeParam = request.getParameter("nome");
		String dataParam = request.getParameter("data"); // recebendo parâmetro para data de abertura
		String idParam = request.getParameter("id");
		
		Integer id = Integer.valueOf(idParam);
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataParam);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println("ID da empresa: " + id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaId(id);
		empresa.setNome(nomeParam);
		empresa.setDataAbertura(dataAbertura);
		
		
		response.sendRedirect("listaEmpresa");
	}

}
