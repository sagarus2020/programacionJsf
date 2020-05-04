package jsfweb.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import  mensaje.Dao.MensajeDao;
import  jpa.entities.Mensaje;

@ManagedBean(name = "MensajeBean")
@RequestScoped
public class MensajeBean {
	
	public String nuevo() {
		Mensaje c= new Mensaje();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("mensaje", c);
		return  "/faces/contact.html";
	}
	
	public String guardar (Mensaje mensaje) {
		//guarda la fecha de registro
		/*
		 * Date fechaActual= new Date(); Mensaje.setFregistro(new
		 * java.sql.Date(fechaActual.getTime()));
		 */
		MensajeDao MensajeDAO= new MensajeDao();
		MensajeDAO.guardar(mensaje);
		return  "/faces/index.html";
	}

	public List<Mensaje> obtenerMensajes() {
		MensajeDao MensajeDAO = new MensajeDao();

		/*
		 * List<Mensaje> listaMensajes = new ArrayList<>(); Mensaje c1 = new Mensaje();
		 * c1.setId(1L); c1.setNombres("Elivar"); c1.setApellidos("Largo");
		 * c1.setDireccion("Loja");
		 * 
		 * Mensaje c2 = new Mensaje(); c2.setId(1L); c2.setNombres("Elivar1");
		 * c2.setApellidos("Largo1"); c2.setDireccion("Loja1"); listaMensajes.add(c1);
		 * listaMensajes.add(c2);
		 * 
		 * return listaMensajes;
		 */
		return MensajeDAO.obtenerMensajes();
	}

	public String editar(Long id) {
		MensajeDao MensajeDAO = new MensajeDao();
		Mensaje c = new Mensaje();
		c = MensajeDAO.buscar(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("Mensaje", c);
		return "/faces/about.html";
	}

	public String actualizar(Mensaje Mensaje) {
		//guarda la fecha de actualizacion
		/*
		 * Date fechaActual= new Date(); Mensaje.setFactualizar(new
		 * java.sql.Date(fechaActual.getTime()));
		 */
		MensajeDao MensajeDAO = new MensajeDao();
		MensajeDAO.editar(Mensaje);
		return "/faces/index.html";
	}

	// eliminar un Mensaje
	public String eliminar(Long id) {
		MensajeDao MensajeDAO = new MensajeDao();
		MensajeDAO.eliminar(id);
		System.out.println("Mensaje eliminado..");
		return "/faces/index.html";
	}

}