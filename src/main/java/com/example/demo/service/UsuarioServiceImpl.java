package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	protected UsuarioRepository  usuarioRepository;

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	@Override
	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		
		this.usuarioRepository.deleteById(id);
	}	
		
	
}
