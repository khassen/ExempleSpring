package fr.treeptik.springsample.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.treeptik.springsample.dao.ClientDAO;
import fr.treeptik.springsample.exception.DAOException;
import fr.treeptik.springsample.model.Client;


//deleguer à spring la creation des instances:  il va les mettre dans sa memoire
@Repository
//@Scope("prototype") //spring va creer 2 instances de la meme classe

public class ClientMemoryDao implements ClientDAO{
	
	private List<Client> clients = new ArrayList<Client>();

	@Override
	public Client save(Client client) throws DAOException {
		clients.add(client);
		return client;
	}

	//il faut genere hashcode et equal pour pour supprimer l'objet
	@Override
	public void remove(Client client) throws DAOException {
		clients.remove(client);
		
	}

	@Override
	public List<Client> findAll() throws DAOException {
		
		return clients;
	}


}
