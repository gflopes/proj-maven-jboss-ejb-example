package br.com.gustavo.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.ws.retorno.Retorno;
import br.com.gustavo.ws.service.TestService;
import br.com.gustavo.ws.utils.Constantes;
import exception.ExcecaoPadrao;

@RequestScoped
@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource extends Resource {
	private static final Logger LOG = LoggerFactory.getLogger(TestResource.class);
	
	@EJB
	private TestService service;
	
	public TestResource() {
		super();
	}
	
	@GET
	public String get() {
		LOG.info("WS: LOG test resteasy");
		
		String test = service.get();
		
		return "Retorno: " + test;
	}
	
	@GET
	@Path("/grupos")
	public Response getGrupos() {
		Retorno retorno = new Retorno();
		
		List<String> msgsErro;
		
		try {
			Status status = Status.OK;
			
			retorno = service.getGrupos();
			
			return build(status, retorno);

		} catch (ExcecaoPadrao e) {
			LOG.error(e.getMessage());
			return build(Status.BAD_REQUEST, montarRetorno(Constantes.ERRO_LISTAR_GRUPOS, Boolean.TRUE));

		} catch (Exception e) {
			LOG.error(Constantes.ERRO_LISTAR_GRUPOS + ": " + e);
			return build(Status.INTERNAL_SERVER_ERROR, montarRetorno(Constantes.ERRO_LISTAR_GRUPOS, Boolean.TRUE));
		}
	}

}
