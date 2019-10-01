package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import com.example.demo.util.QueryResult;
import com.example.demo.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UsuarioController {
	
	@Autowired
	protected UsuarioService usuarioService;
	
	protected ObjectMapper mapper;
	
	
	
	@RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String usuarioJson) 
			throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if(!this.validate(usuario)) {
			
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos Obligatorios no estan diligenciados");
		}
		
		this.usuarioService.save(usuario);
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion Exitosa");
	}
	
	
	@RequestMapping(value="/getAllUsuarios", method = RequestMethod.GET)
	public List<Usuario> getAllUsuarios() {
		
		
		return this.usuarioService.findAllUsuarios();
	}
	

	
	@RequestMapping(value="/deleteUsuario", method = RequestMethod.POST)
	public void deleteUsuario(@RequestBody String usuarioJson) throws Exception {
		this.mapper = new ObjectMapper();
		Usuario usuario = this.mapper.readValue(usuarioJson, Usuario.class);
		
		if(usuario.getId() == null) {
			throw new Exception("El id no puede ser Null");
		}
		
		this.usuarioService.deleteUsuario(usuario.getId());
		
	}
	
	
	
	private boolean validate(Usuario usuario) {
		boolean isValid = true;
		
		if(StringUtils.trimToNull(usuario.getPrimerNombre()) == null) {
			isValid = false;
		}
		
		if(StringUtils.trimToNull(usuario.getPrimerApellido()) == null) {
			isValid = false;
		}
		
		if(StringUtils.trimToNull(usuario.getDireccion()) == null) {
			isValid = false;
		}
		
		return isValid;
		
		
	}
	
	
}
