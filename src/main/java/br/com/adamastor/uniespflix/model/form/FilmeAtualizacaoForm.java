package br.com.adamastor.uniespflix.model.form;

import br.com.adamastor.uniespflix.model.entity.Filme;
import lombok.Data;

@Data
public class FilmeAtualizacaoForm {

	private String titulo;
	
	private String nomeGenero;
	
	private Integer anoLancamento;
	
	private Integer duracaoMinutos;
	
	private String sinopse;
	
	private Integer relevancia;
	
	private String urlTrailler;	
	
	private String urlImagem;
	
	
	public Filme atualizarDados(Filme filme) {
		filme.setTitulo(titulo);
		filme.setAnoLancamento(anoLancamento);
		filme.setDuracaoMinutos(duracaoMinutos);
		filme.setSinopse(sinopse);
		filme.setUrlTrailler(urlTrailler);
		filme.setUrlImagem(urlImagem);
		return filme;
	}

}

