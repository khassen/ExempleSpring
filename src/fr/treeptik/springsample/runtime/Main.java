package fr.treeptik.springsample.runtime;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.springsample.exception.ServiceException;
import fr.treeptik.springsample.model.Client;
import fr.treeptik.springsample.service.ClientService;

public class Main {

	public static void main(String[] args) {

		// charger la configuration de spring, spring va se mettre en route , il
		// va charger toutes mes classes

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ClientService clientService = context.getBean(ClientService.class);
		
		Client client1 = new Client(1,"client1","client1");
		Client client2 = new Client(2,"client2","client2");
		Client client3 = new Client(3,"client3","client3");
		
		
		try {
			clientService.save(client1);
			clientService.save(client2);
			clientService.save(client3);
			List<Client> clients = clientService.findAll();
		System.out.println("nb client : " + clients.size());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		context.close();
	}

}
