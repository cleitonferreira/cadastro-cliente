package curso.dao.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;

/*
 * Essa classe é responsável de criar nossa Conexão com o banco
 * */
public class JdbcDAOFactory extends DAOFactory {

	private Connection connection;
	
	public JdbcDAOFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_cliente"
					, "root", "root");
		} catch (Exception e) {
			throw new RuntimeException("Erro recuperando conexão com o banco", e);
		}
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new JdbcClienteDAO(connection);
	}
	
}
