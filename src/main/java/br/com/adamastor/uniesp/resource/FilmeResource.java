package br.com.adamastor.uniesp.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.uniesp.model.Ator;
import br.com.adamastor.uniesp.model.Filme;

@RestController
@RequestMapping("/filme")
public class FilmeResource {
	
	@GetMapping("/teste")
	public Filme teste() {
		Filme filme = new Filme(1L, "Título filme teste");
		Ator ator1 = new Ator(1L, "Ator 1");
		Ator ator2 = new Ator(2L, "Ator 2");
		Ator ator3 = new Ator(3L, "Ator 3");
		filme.adicionarAtor(ator1);
		filme.adicionarAtor(ator2);
		filme.adicionarAtor(ator3);
		return filme;
	}
	
	@PostMapping
	public String salvar() {
		return "Salvar";
	}
	
	@GetMapping
	public String listar() {
		return "Listar";
	}
	
	@DeleteMapping
	public String remover() {
		return "Remover";
	}
	
	@PutMapping
	public String atualizar() {
		return "Atualizar";
	}

}