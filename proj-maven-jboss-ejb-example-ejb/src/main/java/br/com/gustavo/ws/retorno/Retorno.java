package br.com.gustavo.ws.retorno;

import java.util.List;

public class Retorno {
	private transient Boolean temErro;
	
	private List<String> msgsErro;

	public Boolean isTemErro() {
		return temErro;
	}

	public void setTemErro(final Boolean temErro) {
		this.temErro = temErro;
	}

	public List<String> getMsgsErro() {
		return msgsErro;
	}

	public void setMsgsErro(final List<String> msgsErro) {
		this.msgsErro = msgsErro;
	}
}
