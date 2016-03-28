package curso.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import curso.dao.ClienteDAO;
import curso.dao.DAOException;
import curso.modelo.Cliente;

public class JdbcClienteDAO implements ClienteDAO {

	// preciso de Connection
	// lembre de importar java.sql.Connection - tem que ser dessa forma
	private Connection connection;

	public JdbcClienteDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(Cliente cliente) {
		try {
			String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro salvando cliente", e);
		} finally {
			try {
				// precisa fechar a conexão
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente cliente = null;

		try {
			String sql = String.format("select * from cliente where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return clientes;
	}

	@Override
	public void atualizar(Cliente cliente) {
		try {
			String sql = String.format("update cliente set nome = '%s' where codigo = %d", cliente.getNome(),
					cliente.getCodigo());

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro atualizando cliente", e);
		} finally {
			try {
				// precisa fechar a conexão
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void deletar(Long codigo) {
		try {
			String sql = String.format("delete from cliente where codigo = %d", codigo);

			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Erro ao excluir o cliente", e);
		} finally {
			try {
				// precisa fechar a conexão
				this.connection.close();
			} catch (Exception e) {
			}
		}

	}

}
