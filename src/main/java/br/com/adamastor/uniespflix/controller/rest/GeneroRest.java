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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.uniespflix.model.dto.GeneroDTO;
import br.com.adamastor.uniespflix.model.form.GeneroAtualizacaoForm;
import br.com.adamastor.uniespflix.model.form.GeneroForm;
import br.com.adamastor.uniespflix.model.service.GeneroService;

@RestController
@RequestMapping("/rest/generos")
public class GeneroRest {
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<GeneroDTO>> listarTodosGeneros()){
		List<GeneroDTO> dto = generoService.buscarTodosGeneros();
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPorTitulo/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<GeneroDTO>> buscarSeriePorNome(@PathVariable String nome){
		List<GeneroDTO> dto = generoService.buscarPorNome(nome);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<GeneroDTO> buscarPorId(@PathVariable Long id){
		GeneroDTO dto = generoService.buscarPorId(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<GeneroDTO> cadastrar(@RequestBody @Valid GeneroForm form) {
		GeneroDTO dto = generoService.cadastrar(form);
		
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<GeneroDTO> atualizar(@PathVariable Long id, @RequestBody GeneroAtualizacaoForm form) {
		GeneroDTO dto = generoService.atualizar(id, form);

		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!generoService.deletar(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
	}

}
