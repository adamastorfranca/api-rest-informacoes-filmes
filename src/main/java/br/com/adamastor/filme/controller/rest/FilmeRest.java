package br.com.adamastor.filme.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.filme.model.dto.FilmeDTO;
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

}
