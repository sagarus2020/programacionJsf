package redJpa.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import redJpa.util.Conexion;

public class prueba {
	public static void main(String[] args) {
		 
		 Mensaje m=new Mensaje();
		 m.setNombre("nombre");
		 m.setEmail("email");
		 m.setWebsite("telefono");
		 m.setMensaje("mensaje");
		
		
		 EntityManager em = Conexion.getEm();
		 try {
		 em.getTransaction().begin();
		 em.persist(m);
		 em.getTransaction().commit();
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally {
		 em.close();
		 
		 }
		 }
}
