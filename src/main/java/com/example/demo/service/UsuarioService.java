package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Usuario;

public interface UsuarioService {

	/**
	 * Crea o actualiza un usuario
	 * @param usuario
	 * @return rl usuario guardado
	 */
	Usuario save(Usuario usuario);

	/**
	 * Recupera la lista de usuarios
	 * @return Lista de Usuarios
	 */
	List<Usuario> findAllUsuarios();

}
