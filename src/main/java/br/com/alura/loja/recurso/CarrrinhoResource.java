package br.com.alura.loja.recurso;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.CarrinhoDAO;

@Path("carrinhos")
public class CarrrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca() {
		return new CarrinhoDAO().busca(1L).toXML();
	}
	
}
