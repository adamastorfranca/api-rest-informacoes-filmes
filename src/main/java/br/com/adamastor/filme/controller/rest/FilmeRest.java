package br.com.adamastor.filme.controller.rest;

import java.net.URI;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.adamastor.filme.model.dto.FilmeDTO;
import br.com.adamastor.filme.model.form.AtualizacaoFilmeForm;
import br.com.adamastor.filme.model.form.FilmeForm;
import br.com.adamastor.filme.model.service.FilmeService;

@RestController
@RequestMapping("/rest/filmes")
public class FilmeRest {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<FilmeDTO>> listarTodosFilmes(){
		List<FilmeDTO> dto = filmeService.buscarTodosFilmes();
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPorTitulo/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<FilmeDTO>> buscarFilmePorTitulo(@PathVariable String titulo){
		List<FilmeDTO> dto = filmeService.buscarPorTitulo(titulo);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<FilmeDTO> buscarFilmePorId(@PathVariable Long id){
		FilmeDTO dto = filmeService.buscarPorId(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<FilmeDTO> cadastrar(@RequestBody @Valid FilmeForm form, UriComponentsBuilder uriBuilder) {
		FilmeDTO dto = filmeService.cadastrar(form);
		
		URI uri = uriBuilder.path("rest/filmes/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto); 
	}
	
	@PutMapping(value = "/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoFilmeForm form) {
		FilmeDTO dto = filmeService.atualizar(id, form);

		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		boolean resultado = filmeService.deletar(id);
		
		if (resultado == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
	}

}
