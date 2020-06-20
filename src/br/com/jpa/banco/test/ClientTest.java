package br.com.jpa.banco.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.banco.interfaces.CadClientes;
import br.com.jpa.banco.model.Clients;

public class ClientTest {

	public static void main(String... args) {
		
		
		EntityManagerFactory factory =  
				Persistence.createEntityManagerFactory("Clients-PU");
		EntityManager entityManager = factory.createEntityManager();
		
		int primaryKey = 0;
		Clients clients1 = new Clients();
//		Clients clients2 = new Clients();
		
		clients1.setLoginCliente("2832");
		clients1.setPassword("wwhc");
	
		entityManager.getTransaction().begin();
		entityManager.persist(clients1);
		//entityManager.persist(clients2);
		entityManager.getTransaction().commit();
	}
}

//Utilizado para testes com JPA
//clients1.setIdCliente(2);
//clients1.setLoginCliente("re3746");
//clients1.setPassword("397hsyd");
//
//clients2.setLoginCliente("209392");
//clients2.setPassword("17011997");
