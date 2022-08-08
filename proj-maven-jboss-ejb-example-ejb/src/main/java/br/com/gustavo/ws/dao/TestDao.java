package br.com.gustavo.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.ws.entity.GrupoEntity;
import br.com.gustavo.ws.retorno.GrupoRetorno;
import br.com.gustavo.ws.utils.Constantes;
import exception.ExcecaoPadrao;

@Stateless
@Named
public class TestDao {
	private static final Logger LOG = LoggerFactory.getLogger(TestDao.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	public TestDao() {
		super();
	}
	
	public String get() {
		LOG.info("DAO: LOG test resteasy");
		
		return "test resteasy";
	}
	
	public GrupoRetorno getGrupos() {
		
		List<String> msgsErro = new ArrayList();
		GrupoRetorno retorno = new GrupoRetorno();
		
		try {
			final StringBuilder sql = new StringBuilder("select * from grupo order by nmgrupo");
			

			Query query = em.createNativeQuery(sql.toString(), GrupoEntity.class);

			final List<GrupoEntity> lista = query.getResultList();

			msgsErro.add(Constantes.SUCESSO);
			retorno.setTemErro(Boolean.FALSE);
			retorno.setMsgsErro(msgsErro);
			retorno.getData().addAll(lista);
			
		} catch (NoResultException e) {
			LOG.warn(e.getMessage());
			msgsErro.add(Constantes.NENHUM_REGISTRO_ENCONTRADO);
			retorno.setTemErro(Boolean.TRUE);
			retorno.setMsgsErro(msgsErro);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			msgsErro.add(Constantes.ERRO_LISTAR_GRUPOS);
			retorno.setTemErro(Boolean.TRUE);
			retorno.setMsgsErro(msgsErro);
			throw new ExcecaoPadrao(Constantes.ERRO_LISTAR_GRUPOS, e);
		}
		
		return retorno;
	}

}
