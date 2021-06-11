package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String data = request.getParameter("data"); // recebendo parâmetro para data de abertura
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		// Agora, vai enviar a requisição com as empresas do Banco para servlet "lista empresa"
		
		/* cria uma referência de RequestDispatcher que recebe um objeto
		 criado pelo método "getReq..." de "request". Esse método recebe
		 como parâmetro o caminho para onde o objeto "rd" deve encaminhar	
		 as requisições	*/	
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa"); 
		
		/* Associa à requisição aquilo que eu quero enviar para o servlet "listaEmpresa"
		 * ".setAttribute" recebe dois parâmetros: um nome String (apelido) e um Object
		 * 
		 */
		System.out.println("Passou pela Nova Empresa Servlet");
		System.out.println("Vai para: Lista Empresa Servlet");
		
		request.setAttribute("emp", empresa.getNome());
		rd.forward(request, response);
		
		
		
	}

}
