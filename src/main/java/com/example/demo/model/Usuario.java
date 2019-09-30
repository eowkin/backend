package com.example.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@Access(AccessType.FIELD)
public class Usuario extends ParentEntity{
	
	private static final long serialVersionUID = -8706549357085855246L;
	
	@Column(name="primer_nombre", nullable = false, length = 255)
	private String primerNombre;
	
	@Column(name="segundo_nombre", nullable = true, length = 255)
	private String segundoNombre;
	
	@Column(name="primer_apellido", nullable = false, length = 255)
	private String primerApellido;
	
	@Column(name="segundo_apellido", nullable = true, length = 255)
	private String segundoApellido;
	
	@Column(name="telefono", nullable = false, length = 30)
	private String telefono;
	
	@Column(name="direccion", nullable = true, length = 150)
	private String direccion;

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	

}
