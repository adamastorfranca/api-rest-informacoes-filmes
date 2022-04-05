package br.com.adamastor.uniespflix.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Plano;
import lombok.Data;

@Data
public class PlanoDTO {
	
	private String nome;
	private String descricao;
	private String resolucao;
	private BigDecimal valor;
	
	public PlanoDTO(Plano plano) {
		this.nome = plano.getNome();
		this.descricao = plano.getDescricao();
		this.valor = plano.getValor();
	}

	public static List<PlanoDTO> converter(List<Plano> planos){
		return planos.stream().map(PlanoDTO::new).collect(Collectors.toList());
	}
}