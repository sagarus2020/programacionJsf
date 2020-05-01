package jpa.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import jpa.entities.Usuario;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Usuario usuario;

		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear usuario");
			System.out.println("2. Buscar usuario");
			System.out.println("3. Actualizar usuario");
			System.out.println("4. Eliminar usuario");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite el nombre del usuario:");
				usuario = new Usuario();
				usuario.setUsuario("Juan");
				usuario.setNombre("Juan");
				usuario.setClave("Juan");
				usuario.setCorreo("Juan");
				usuario.setTelefono("Juan");
				usuario.setDireccion("Juan");
				scanner.nextLine();
				scanner.nextLine();
				usuario.setNombre(scanner.nextLine());

				System.out.println("Digite el precio del usuario:");
				usuario.setNombre(scanner.next());
				System.out.println(usuario);
				entity.getTransaction().begin();
				entity.persist(usuario);
				entity.getTransaction().commit();
				System.out.println("usuario registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del usuario a buscar:");
				usuario = new Usuario();
				usuario = entity.find(Usuario.class, scanner.nextLong());
				if (usuario != null) {
					System.out.println(usuario);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("usuario no encontrado... Lista de usuarios completa");
					List<Usuario> listausuarios= new ArrayList<>();
					Query query=entity.createQuery("SELECT p FROM usuario p");
					listausuarios=query.getResultList();
					for (Usuario p : listausuarios) {
						System.out.println(p);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del usuario a actualizar:");
				usuario = new Usuario();

				usuario = entity.find(Usuario.class, scanner.nextLong());
				if (usuario != null) {
					System.out.println(usuario);
					System.out.println("Digite el nombre del usuario:");
					scanner.nextLine();
					usuario.setNombre(scanner.nextLine());
					System.out.println("Digite el precio del usuario:");
					usuario.setNombre(scanner.next());
					entity.getTransaction().begin();
					entity.merge(usuario);
					entity.getTransaction().commit();
					System.out.println("usuario actualizado..");
					System.out.println();
				} else {
					System.out.println("usuario no encontrado....");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del usuario a eliminar:");
				usuario = new Usuario();

				usuario = entity.find(Usuario.class, scanner.nextLong());
				if (usuario != null) {
					System.out.println(usuario);
					entity.getTransaction().begin();
					entity.remove(usuario);
					entity.getTransaction().commit();
					System.out.println("usuario eliminado...");
				} else {
					System.out.println("usuario no encontrado...");
				}
				break;
			case 5:entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}

