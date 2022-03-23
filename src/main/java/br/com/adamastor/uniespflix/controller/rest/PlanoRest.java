package br.com.adamastor.uniespflix.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.uniespflix.model.dto.PlanoDTO;
import br.com.adamastor.uniespflix.model.service.PlanoService;

@RestController
@RequestMapping("/rest/planos")
public class PlanoRest {
	
	@Autowired
	private PlanoService planoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<PlanoDTO>> listarTodosPlanos(){
		List<PlanoDTO> dto = planoService.buscarTodosPlanos();
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
