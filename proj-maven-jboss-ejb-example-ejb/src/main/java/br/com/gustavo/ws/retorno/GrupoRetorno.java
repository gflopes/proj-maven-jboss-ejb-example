package br.com.gustavo.ws.retorno;

import java.util.ArrayList;
import java.util.List;

import br.com.gustavo.ws.entity.GrupoEntity;

public class GrupoRetorno extends Retorno {
	private List<GrupoEntity> data;
	
	public GrupoRetorno() {
		super();
		data = new ArrayList();
	}

	public List<GrupoEntity> getData() {
		return data;
	}

	public void setData(List<GrupoEntity> data) {
		this.data = data;
	}

}
