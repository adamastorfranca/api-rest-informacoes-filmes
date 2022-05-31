package br.com.adamastor.uniespflix.controller.rest;

import java.util.List;

import javax.validation.Valid;

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

import br.com.adamastor.uniespflix.model.dto.GeneroResponseDTO;
import br.com.adamastor.uniespflix.model.entity.Genero;
import br.com.adamastor.uniespflix.model.form.GeneroAtualizacaoForm;
import br.com.adamastor.uniespflix.model.form.GeneroForm;
import br.com.adamastor.uniespflix.model.service.GeneroService;

@RestController
@RequestMapping("/rest/generos")
public class GeneroRest {
	
	@Autowired
	private GeneroService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<GeneroResponseDTO>> buscar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "nome", required = false) String nome) {
		List<Genero> resultado = service.buscar(id, nome);

		return new ResponseEntity<>(GeneroResponseDTO.converter(resultado), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<GeneroResponseDTO> cadastrar(@RequestBody @Valid GeneroForm form) {
		GeneroResponseDTO dto = service.cadastrar(form);
		
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<GeneroResponseDTO> atualizar(@PathVariable Long id, @RequestBody GeneroAtualizacaoForm form) {
		GeneroResponseDTO dto = service.atualizar(id, form);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {

		return new ResponseEntity<>(HttpStatus.OK);	
	}

}
