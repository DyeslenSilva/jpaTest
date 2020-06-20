package br.com.jpa.banco.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.banco.model.Clients;

public class ClientDAO {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		
		try {
			factory =  Persistence.createEntityManagerFactory("clients");
			entityManager = factory.createEntityManager();
		}finally {
			//factory.close();
		}
		
		return entityManager;
	}
	
	public Clients saveClients(Clients cli) throws Exception{
		EntityManager manager = getEntityManager();
		try {
			manager.getTransaction().begin();
			
			System.out.println("Salvando....");
			
			if(cli.getIdCliente()==null) {
				manager.persist(manager);
				
			}else {
				cli = manager.merge(cli);
			}	
			manager.getTransaction().commit();
		}finally {
			manager.close();
		}
		return cli;
	}
	
	

}
