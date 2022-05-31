package br.com.adamastor.uniespflix.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.uniespflix.model.dto.FilmeRequestDTO;
import br.com.adamastor.uniespflix.model.dto.FilmeResponseDTO;
import br.com.adamastor.uniespflix.model.entity.Filme;
import br.com.adamastor.uniespflix.model.form.FilmeAtualizacaoForm;
import br.com.adamastor.uniespflix.model.service.FilmeService;


@RestController
@RequestMapping("/rest/filmes")
public class FilmeRest {
	
	@Autowired
	private FilmeService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<FilmeResponseDTO>> buscar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "titulo", required = false) String titulo) {
		List<Filme> resultado = service.buscar(id, titulo);

		return new ResponseEntity<>(FilmeResponseDTO.converter(resultado), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<FilmeResponseDTO> cadastrar(@RequestBody FilmeRequestDTO form) {
		FilmeResponseDTO dto = new FilmeResponseDTO(service.cadastrar(form));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<FilmeResponseDTO> atualizar(@PathVariable Long id, @RequestBody FilmeAtualizacaoForm form) {
		FilmeResponseDTO dto = service.atualizar(id, form);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return new ResponseEntity<>(HttpStatus.OK);	
	}

}
