package fr.treeptik.springsample.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.treeptik.springsample.dao.impl.ClientMemoryDao;

@Configuration
public class DAOFactory {
	
	@Bean
	public ClientDAO getClientDAO(){
		//
		//lire dans fichier
		//si spring ne peux pas le faire
		//parce la creation de l'objet est complexe, 
		//ca explique à spring comment ecrire des objets de ce type
		//se ne pas spring qui s'occupe de creation des objets, mais je vais gardre les autowireds
		
		return new ClientMemoryDao();
		
	}

}
