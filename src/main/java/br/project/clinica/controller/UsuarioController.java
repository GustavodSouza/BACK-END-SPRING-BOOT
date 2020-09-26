package br.project.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.project.clinica.model.Usuario;
import br.project.clinica.service.UsuarioService;

@RestController
@RequestMapping("/service")
@Controller
public class UsuarioController {
	
	@Autowired()
	private UsuarioService usuarioService;
	
	@PostMapping("/add")
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}
	
	@GetMapping("/list")
	public List<Usuario> getAllUsers() {
		return usuarioService.getUsuarios();
	}
}
