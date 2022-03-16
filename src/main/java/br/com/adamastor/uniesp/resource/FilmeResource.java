package br.com.adamastor.uniesp.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.uniesp.model.Filme;

@RestController
@RequestMapping("/filme")
public class FilmeResource {
	
	@GetMapping("/teste")
	public Filme teste() {
		Filme filme = new Filme();
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