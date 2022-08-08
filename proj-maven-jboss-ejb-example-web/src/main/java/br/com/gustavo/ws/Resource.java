package br.com.gustavo.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.ws.retorno.Retorno;

public class Resource {
	private static final Logger LOGGER = LoggerFactory.getLogger(Resource.class);
    
    private static ValidatorFactory factory;

	@OPTIONS
	@Path("{path : .*}")
	public Response options() {
	    return Response.ok("").build();
	}

	protected Response build(Status status, Object object) {
		return Response.status(status).entity(object).build();
	}
    
    protected List<String> validarJSon(final Object obj) {
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Object>> lista = validator.validate(obj);
        
        List<String> msgsErro = new ArrayList<String>();

        if (lista.size() > 0) {
	        for (ConstraintViolation<Object> item : lista) {
	        	msgsErro.add("Propriedade [" + item.getPropertyPath() + "]: " + item.getMessage());
	        	LOGGER.info("Propriedade [" + item.getPropertyPath() + "]: " + item.getMessage());
	        }
        }
        return msgsErro;
    }
	
	protected Retorno getMensagemErro(final String msg){
		 Retorno retorno = new Retorno();

		 List<String> msgs = new ArrayList<String>();
		 msgs.add(msg);
		 retorno.setMsgsErro(msgs);
		 
		 return retorno;
	}
	
	protected Retorno montarRetorno(final String mensagem, Boolean temErro) {
		Retorno retorno = new Retorno();
		List<String> msgErro = new ArrayList<String>();

		msgErro.add(mensagem);
		retorno.setTemErro(temErro);
		retorno.setMsgsErro(msgErro);

		return retorno;
	}
}