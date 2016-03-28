package curso.dao;

import java.util.List;

import curso.modelo.Cliente;

public interface ClienteDAO {

	public void salvar(Cliente cliente);

	public Cliente buscarPeloCodigo(Long codigo);

	public List<Cliente> buscarTodos();

	public void atualizar(Cliente cliente);

	public void deletar(Long codigo);
	
}
