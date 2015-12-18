package arz.simugravit.application.exception;

public class SimuApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6744396087176724968L;

	public SimuApplicationException(String string, NumberFormatException ex) {
		
		super(string, ex);
	}

	public SimuApplicationException(String string) {
		super();
	}
	
	

}
