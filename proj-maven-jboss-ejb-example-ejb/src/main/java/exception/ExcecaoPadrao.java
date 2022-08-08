package exception;

public class ExcecaoPadrao extends RuntimeException {

	private static final long serialVersionUID = 3491456196123841751L;

	public ExcecaoPadrao() {
		super();
	}

	public ExcecaoPadrao(final String msg) {
		super(msg);
	}

	public ExcecaoPadrao(final Throwable erro) {
		super(erro);
	}

	public ExcecaoPadrao(final String msg, final Throwable erro) {
		super(msg, erro);
	}
}
