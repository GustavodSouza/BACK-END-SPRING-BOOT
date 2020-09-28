package br.project.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.project.clinica.model.Usuario;
import br.project.clinica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario encontrarUsuario(Integer id) {
		Optional<Usuario> optUser = usuarioRepository.findById(id);
		return optUser.get();
	}
	
	public void deletarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
