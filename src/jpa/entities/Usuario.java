package jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usuario;

	private String clave;

	private String correo;

	private String nombre;

	//bi-directional many-to-one association to Campana
	@OneToMany(mappedBy="usuarioBean")
	private List<Campana> campanas;

	public Usuario() {
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Campana> getCampanas() {
		return this.campanas;
	}

	public void setCampanas(List<Campana> campanas) {
		this.campanas = campanas;
	}

	public Campana addCampana(Campana campana) {
		getCampanas().add(campana);
		campana.setUsuarioBean(this);

		return campana;
	}

	public Campana removeCampana(Campana campana) {
		getCampanas().remove(campana);
		campana.setUsuarioBean(null);

		return campana;
	}

}