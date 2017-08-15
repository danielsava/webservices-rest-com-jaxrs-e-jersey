package br.com.alura.loja.teste;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.Servidor;

public class LocalhostTest {
	
	private HttpServer server;
	
	@Before
	public void initServer() {
		server = Servidor.startaServidor();
	}
	
	@After
	public void stopServer() {
		server.stop();
	}

	@Test
	public void testeProjetoResource() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("Minha Loja"));
	}
	
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("Rua Vergueiro 3185 8 andar"));
	}

}
