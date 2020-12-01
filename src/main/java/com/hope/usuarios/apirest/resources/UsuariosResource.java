package com.hope.usuarios.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hope.usuarios.apirest.models.Usuarios;
import com.hope.usuarios.apirest.repository.UsuariosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Usuarios")
public class UsuariosResource {

	@Autowired
	UsuariosRepository usuariosRepository;

	@ApiOperation(value = "Retorna uma lista de usuarios")
	@GetMapping("/listagem")
	public List<Usuarios> listaUsuarios() {
		return usuariosRepository.findAll();
	}

	@ApiOperation(value = "Retorna um usuario unico")
	@GetMapping("/usuario/{id}")
	public Usuarios listaUsuariosUnico(@PathVariable(value = "id") long codigo) {
		return usuariosRepository.findById(codigo);
	}

	@ApiOperation(value = "Salva um usuario")
	@PostMapping("/novo")
	public Usuarios salvaUsuarios(@RequestBody @Valid Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

	@ApiOperation(value = "Deleta um usuario")
	@DeleteMapping("/removido")
	public void deletaUsuarios(@RequestBody @Valid Usuarios usuarios) {
		usuariosRepository.delete(usuarios);
	}

	@ApiOperation(value = "Atualiza um usuario")
	@PutMapping("/modificado")
	public Usuarios atualizaUsuarios(@RequestBody @Valid Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

}
