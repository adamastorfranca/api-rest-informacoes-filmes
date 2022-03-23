package br.com.adamastor.uniespflix.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Plano;

public class PlanoDTO {
	
	private String nome;
	private String descricao;
	private String resolucao;
	private BigDecimal valor;
	
	public PlanoDTO(Plano plano) {
		this.nome = plano.getNome();
		this.descricao = plano.getDescricao();
		this.resolucao = plano.getResolucao();
		this.valor = plano.getValor();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getResolucao() {
		return resolucao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public static List<PlanoDTO> converter(List<Plano> planos){
		return planos.stream().map(PlanoDTO::new).collect(Collectors.toList());
	}
}