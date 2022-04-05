package br.com.adamastor.uniespflix.model.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.model.entity.Cartao;
import br.com.adamastor.uniespflix.model.repository.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	public Cartao cadastrar(String numeroCartao, LocalDate validade, String codigoSeguranca, String nomeTitular, String cpf) {
		Cartao c = new Cartao();
		c.setNumeroCartao(numeroCartao);
		c.setValidade(validade);
		c.setCodigoSeguranca(codigoSeguranca);
		c.setNomeTitular(nomeTitular);
		c.setCpf(cpf);
		
		cartaoRepository.save(c);
		
		return c;
	}
}
