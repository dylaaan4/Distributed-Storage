package Exceptions;
public class NoFileToReadException extends Exception {
	public NoFileToReadException() {
        super("No file to exception") ;
    }

	public NoFileToReadException(String message) {
		super(message);
	}
    
}
