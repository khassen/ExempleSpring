package fr.treeptik.springsample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.springsample.dao.ClientDAO;
import fr.treeptik.springsample.exception.DAOException;
import fr.treeptik.springsample.exception.ServiceException;
import fr.treeptik.springsample.model.Client;
import fr.treeptik.springsample.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	// injection d'une reference: ca remplace l'appel de notre factory, il va
	// creer des singleton par defaut

	@Autowired
	
	// je precise le type de l'instance pour ne ps avoir une erreur. 2 variable
	// qui pointe sur la meme instance
	//@Qualifier("clientMemoryDao") si je confiqure par un factory je le supprime
	private ClientDAO clientDAO;
	
	@Autowired
	//@Qualifier("clientJDBCDAO") si je confiqure par un factory je le supprime
	private ClientDAO clientDAO1;

	// mais on peut utiliser le scop pour creer plusieurs instances de la meme
	// classe
	// @Autowired
	// private ClientDAO clientDAO1;

	@Override
	public Client save(Client client) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			client = clientDAO.save(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return client;
	}

	@Override
	public void remove(Client client) throws ServiceException {
		try {
			clientDAO.remove(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public List<Client> findAll() throws ServiceException {
		List<Client> clients = null;
		try {
			clients = clientDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return clients;
	}

}
