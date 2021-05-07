package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	public static List<Empresa> lista = new ArrayList<>();
	
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresa() {
		return Banco.lista;
	}
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		
		Banco.lista.add(empresa1);
		Banco.lista.add(empresa2);
	}
}
