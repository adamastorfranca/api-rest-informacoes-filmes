package br.com.adamastor.uniespflix.model.form;

import br.com.adamastor.uniespflix.model.entity.Serie;
import lombok.Data;

@Data
public class AtualizacaoSerieForm {

	private String titulo;
	private String nomeGenero;
	private Integer anoLancamento;
	private Integer temporadas;
	private String sinopse;
	private Integer relevancia;
	private String urlTrailler;	
	
	public Serie atualizarDados(Serie serie) {
		if(!titulo.isEmpty()) {
			serie.setTitulo(titulo);
		}
		if(anoLancamento != null || (anoLancamento >= 1900 && anoLancamento <= 2022)) {
			serie.setAnoLancamento(anoLancamento);
		}
		if(temporadas != null || temporadas < 0) {
			serie.setTemporadas(temporadas);
		}
		if(sinopse.isEmpty()) {
			serie.setSinopse(sinopse);
		}
		if(relevancia != null || (relevancia >= 0 && relevancia <= 100)) {
			serie.setRelevancia(relevancia);
		}
		if(!urlTrailler.isEmpty()) {
			serie.setUrlTrailler(urlTrailler);
		}
		return serie;
	}

}

