package redJpa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernatenormal.HibernateSession;
import redJpa.entities.Usuario;
public class PruebaHbiernate {
 
//Prueba sencilla, persiste una nueva entidad
 
public static void main(String[] args) throws Exception{
SessionFactory sessionFactory = HibernateSession.getSessionFactory();
 
Session session = sessionFactory.openSession();
Transaction tr = session.beginTransaction();
Usuario p = new Usuario();
p.setUsuario("Juan");
p.setNombre("Juan");
p.setClave("Juan");
p.setCorreo("Juan");
p.setTelefono("Juan");
p.setDireccion("Juan");
session.save(p);
tr.commit();
System.out.println("Se guardó satisfactoriamente");
sessionFactory.close();
 
}
}