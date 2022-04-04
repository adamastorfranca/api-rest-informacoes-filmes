package br.com.adamastor.uniespflix.exception;

public enum ExceptionValidacoes {

	ERRO_EMAIL_JA_CADASTRADO("O e-mail informado já está cadastrado."),
	ERRO_SENHAS_NAO_CORRESPONDEM("As senhas informadas não correspondem."),
	
	ERRO_FILME_NAO_ENCONTRADO("Filme não encontrado no banco de dados."),
	ERRO_SERIE_NAO_ENCONTRADA("Série não encontrada no banco de dados."),
	ERRO_GENERO_NAO_ENCONTRADO("Gênero não encontrado no banco de dados.");
	
	private ExceptionValidacoes(String mensagem) {}
	
	
	
}
