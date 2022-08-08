package br.com.gustavo.ws.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.ws.dao.TestDao;
import br.com.gustavo.ws.retorno.GrupoRetorno;

@Stateless
@Named
public class TestService {
	private static final Logger LOG = LoggerFactory.getLogger(TestService.class);
	
	@EJB
	private TestDao dao;
	
	public TestService() {
		super();
	}
	
	public String get() {
		LOG.info("SERVICE: LOG test resteasy");
		
		String test = dao.get();
		
		return test;
	}
	
	public GrupoRetorno getGrupos() {
		return dao.getGrupos();
	}

}
