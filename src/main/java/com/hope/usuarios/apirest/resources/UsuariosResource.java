package com.hope.usuarios.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hope.usuarios.apirest.models.Usuarios;
import com.hope.usuarios.apirest.repository.UsuariosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Usuarios")
public class UsuariosResource {

	@Autowired
	UsuariosRepository ur;
	

	@ApiOperation(value="Retorna uma lista de usuários")
	@GetMapping("/listar")
	public List<Usuarios> listagem() {
		return ur.findAll();
	}

	@ApiOperation(value="Retorna um usuario")
	@GetMapping("/usuario/{codigo}")
	public Usuarios usuario(@PathVariable(value="codigo") long codigo) {
		return ur.findById(codigo);
	}

	@ApiOperation(value="Salva um registro")
	@PostMapping("/novo")
	public Usuarios salvar(@RequestBody Usuarios usuario) {
		return ur.save(usuario);
	}

	@ApiOperation(value="Remove um usuario")
	@DeleteMapping("/delete")
	public void remover(@RequestBody Usuarios usuario) {
		ur.delete(usuario);
	}

	@ApiOperation(value="Altera um registro")
	@PutMapping("/modifica")
	public Usuarios alterar(@RequestBody Usuarios usuario) {
		return ur.save(usuario);
	}
	
}
