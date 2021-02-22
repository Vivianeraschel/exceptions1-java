package model.exceptions;

public class DomainException extends Exception {
//Exception o compilador te obriga a tratar
//poderia ser -- > public class DomainException extends RunTimeException { //RunTimeException o compilador N�O te obriga a tratar
	
	private static final long serialVersionUID = 1L; //� obrigado a fazer isso por causa do DomainException
	
	public DomainException (String msg) {
		super(msg);
	}

}
