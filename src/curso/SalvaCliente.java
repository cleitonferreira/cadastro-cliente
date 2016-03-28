package curso;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import curso.dao.ClienteDAO;
import curso.dao.DAOFactory;
import curso.modelo.Cliente;

/*
 * Conexão JDBC
 * */

public class SalvaCliente {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		Cliente cliente = new Cliente();
		
		String nome = JOptionPane.showInputDialog(null, "Nome do cliente"
				, "Cadastro de cliente", JOptionPane.QUESTION_MESSAGE);
		
		if (nome != null) {
			cliente.setNome(nome);
		
			ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
			clienteDAO.salvar(cliente);
			System.out.println("Cliente salvo com sucesso.");
		}
	}
	
}
