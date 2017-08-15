package br.com.alura.loja;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws Exception {
		HttpServer server = startaServidor();
		System.out.println("Servidor Rodando");
		server.start();
		System.in.read();
		server.stop();
	}
	
	public static HttpServer startaServidor() {
		URI uri = URI.create("http://localhost:8080");
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
		return GrizzlyHttpServerFactory.createHttpServer(uri, config);
	}
	
}
