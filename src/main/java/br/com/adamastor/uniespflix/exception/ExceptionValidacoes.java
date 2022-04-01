package br.com.adamastor.uniespflix.exception;

public enum ExceptionValidacoes {

	ERRO_FILME_NAO_ENCONTRADO("Filme não encontrado no banco de dados."),
	ERRO_SERIE_NAO_ENCONTRADA("Série não encontrada no banco de dados."),
	ERRO_GENERO_NAO_ENCONTRADO("Gênero não encontrado no banco de dados;");
	
	private ExceptionValidacoes(String mensagem) {}
	
	
	
}
