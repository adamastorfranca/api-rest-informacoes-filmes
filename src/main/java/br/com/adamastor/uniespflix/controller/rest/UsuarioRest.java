package br.com.adamastor.uniespflix.controller.rest;

import java.util.List;

import javax.transaction.Transactional;
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

import br.com.adamastor.uniespflix.model.dto.UsuarioRequestDTO;
import br.com.adamastor.uniespflix.model.dto.UsuarioResponseDTO;
import br.com.adamastor.uniespflix.model.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuarios")
@Transactional
public class UsuarioRest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<UsuarioResponseDTO>> listarTodosUsuarios(){
		List<UsuarioResponseDTO> dto = usuarioService.buscarTodosUsuarios();

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody @Valid UsuarioRequestDTO form) {
		UsuarioResponseDTO dto = new UsuarioResponseDTO(usuarioService.cadastrar(form));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
//	
//	@PutMapping(value = "/atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody ResponseEntity<UsuarioResponseDTO> autalizar(@RequestBody @Valid UsuarioAtualizacaoForm form) {
//		UsuarioResponseDTO dto = usuarioService.atualizar(form);
//		
//		if (dto == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(dto, HttpStatus.OK);
//	}
//	
//	@DeleteMapping(value = "/deletar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody ResponseEntity<Void> deletar(@PathVariable Long id) {
//		boolean deletou = usuarioService.deletar(id);
//		
//		if (!deletou) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(HttpStatus.OK);
//	}

}
