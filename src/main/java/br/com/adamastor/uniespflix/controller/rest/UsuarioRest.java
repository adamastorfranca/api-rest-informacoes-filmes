package br.com.adamastor.uniespflix.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.adamastor.uniespflix.model.dto.UsuarioDTO;
import br.com.adamastor.uniespflix.model.form.UsuarioForm;
import br.com.adamastor.uniespflix.model.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuarios")
public class UsuarioRest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<UsuarioDTO>> listarTodosUsuarios(){
		List<UsuarioDTO> dto = usuarioService.buscarTodosUsuarios();
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioForm form) {
		UsuarioDTO dto = usuarioService.cadastrar(form);
		
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
