package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	public static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresa() {
		return Banco.lista;
	}
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(Banco.chaveSequencial++);
		empresa1.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		
		Banco.lista.add(empresa1);
		Banco.lista.add(empresa2);
	}
	
	public void remove(Integer id) {
		
		Iterator<Empresa> it = Banco.lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				Banco.lista.remove(emp);
			}
		}
		
	}
}
