package org.zerock.seoulive.member.information.exception;

public class ControllerException extends Exception{
	private static final long serialVersionUID = -3641399688300723640L;

	public ControllerException(String message) {
		super(message);
	} // Default Construcotr
	
	public ControllerException(Exception originalException) {
		super(originalException);
	} // Default Construcotr
}