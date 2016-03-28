package curso;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;
import curso.modelo.Cliente;

public class AtualizaCliente {

	public static void main(String[] args) throws Exception {

		Cliente cliente = new Cliente();
		cliente.setNome("Teste");
		cliente.setCodigo(2L);
		
		//verfica se o código é diferente de nulo
		if (cliente.getCodigo() != null) {
			
			ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
			clienteDAO.atualizar(cliente);
			System.out.println("Cliente atualizado com sucesso.");
		}

	}

}
