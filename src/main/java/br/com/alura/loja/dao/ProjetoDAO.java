package br.com.alura.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoDAO {

	private static Map<Long, Projeto> banco = new HashMap<>();
	private static AtomicLong contador = new AtomicLong(1);

	static {
		banco.put(1L, Projeto.of(1L, "Minha Loja", 2014));
		banco.put(2L, Projeto.of(2L, "Alura", 2012));
	}
	
	public static ProjetoDAO of() {
		return new ProjetoDAO();
	}
	
	public void adiciona(Projeto projeto) {
		long id = contador.incrementAndGet();
		projeto.setId(id);
		banco.put(id, projeto);
	}
	
	public Projeto buscar(long id) {
		return banco.get(id);
	}
	
	public Projeto remove(long id) {
		return banco.remove(id);
	}
	
}
