package curso;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;

public class ExcluirCliente {

	public static void main(String[] args) {

		// declarando a variável
		Long codigo = null;

		// desejo deletar o registro de cógigo = 2 do Banco de Dados
		codigo = 2L;

		// verfica se o código é diferente de nulo
		if (codigo != null) {

			ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
			clienteDAO.deletar(codigo);
			System.out.println("Cliente excluído com sucesso.");
		}

	}

}
