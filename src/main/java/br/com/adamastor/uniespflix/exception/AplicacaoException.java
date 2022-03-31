package br.com.adamastor.uniespflix.exception;

public class AplicacaoException extends RuntimeException {

	private static final long serialVersionUID = -1949130365425446647L;

	public AplicacaoException(ExceptionValidacoes exception) {
		super(exception.toString());
	}

}
