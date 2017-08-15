package br.com.alura.loja.recurso;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.CarrinhoDAO;

@Path("carrinhos")
public class CarrrinhoResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id) {
		return CarrinhoDAO.of().busca(id).toXML();
	}
	
	/*	
	 * 
	 * @Path -> as barras já estão implícitas. Por isso é desnecessário informá-las.	
	 * 
	 * @QueryParam("id") -> vem como parâmetro da URI: http://localhost:8080/carrinhos?id=1
	 * 
	 * @PathParam("id")  -> forma a URI: http://localhost:8080/carrinhos/1 
	 * 
	 * 
	 * 
	 */
	
}
