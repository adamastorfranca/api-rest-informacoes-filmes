package br.com.adamastor.uniespflix.controller.rest;

import java.util.List;

import javax.transaction.Transactional;

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

import br.com.adamastor.uniespflix.model.dto.UsuarioRequestDTO;
import br.com.adamastor.uniespflix.model.dto.UsuarioResponseDTO;
import br.com.adamastor.uniespflix.model.entity.Usuario;
import br.com.adamastor.uniespflix.model.form.UsuarioAtualizacaoForm;
import br.com.adamastor.uniespflix.model.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuarios")
@Transactional
public class UsuarioRest {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<UsuarioResponseDTO>> buscar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "nomeCompleto", required = false) String nome,
			@RequestParam(value = "email", required = false) String email) {
		List<Usuario> resultado = service.buscar(id, nome, email);

		return new ResponseEntity<>(UsuarioResponseDTO.converter(resultado), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody UsuarioRequestDTO form) {
		UsuarioResponseDTO dto = new UsuarioResponseDTO(service.cadastrar(form));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<UsuarioResponseDTO> autalizar(@PathVariable Long id, @RequestBody UsuarioAtualizacaoForm form) {
		UsuarioResponseDTO dto = new UsuarioResponseDTO(service.atualizar(id, form));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Void> deletar(@PathVariable Long id) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
