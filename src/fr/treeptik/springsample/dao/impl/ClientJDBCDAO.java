package fr.treeptik.springsample.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.treeptik.springsample.dao.ClientDAO;
import fr.treeptik.springsample.exception.DAOException;
import fr.treeptik.springsample.model.Client;

@Repository
public class ClientJDBCDAO implements ClientDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public Client save(Client client) throws DAOException {

		try {
			Connection connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			connection.prepareStatement(
					"Insert into client Values (1,'Super Client')")
					.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public void remove(Client client) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return new ArrayList<Client>();
	}
}
