package cn.edu.sicau.rs.exception;

public class NameNotFoundException extends RuntimeException{
	public NameNotFoundException(String message){
		super(message);
	}
}