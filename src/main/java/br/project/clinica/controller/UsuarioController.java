package br.project.clinica.controller;

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

import br.project.clinica.model.Usuario;
import br.project.clinica.service.UsuarioService;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(origins = "http://localhost:4200") //Endereço do front (Erro de CORS);
public class UsuarioController {
	
	@Autowired()
	private UsuarioService usuarioService;
	
	//Adiciona um dado
	@PostMapping("/adicionar")
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}
	
	//Lista todos dados
	@GetMapping("/listar")
	public List<Usuario> getAllUsers() {
		return usuarioService.getUsuarios();
	}
	
	//Deletar usuario
	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id) {
		
		Usuario usuario = usuarioService.encontrarUsuario(id);
		
		try {
			usuarioService.deletarUsuario(usuario);
			return "Ok";
		} catch(Exception e) {
			return "Erro";
		}
	}
	
	//Atualizar usuario
	@PutMapping("/atualizar")
	public String atualizar(@RequestBody Usuario usuario) {
		try {
			usuarioService.saveUsuario(usuario);
			return "Ok";
		}catch(Exception e) {
			return "Erro";
		}
	}
}
