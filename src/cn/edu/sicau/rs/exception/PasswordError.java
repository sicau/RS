package cn.edu.sicau.rs.exception;

public class PasswordError extends RuntimeException {
	public PasswordError(String message){
		super(message);
	}
}
