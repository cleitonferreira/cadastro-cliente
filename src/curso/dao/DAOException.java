package curso.dao;

//Uma exceção checada
public class DAOException extends RuntimeException {

	public DAOException(String msg, Throwable t) {
		super(msg, t);
	}
	
}
