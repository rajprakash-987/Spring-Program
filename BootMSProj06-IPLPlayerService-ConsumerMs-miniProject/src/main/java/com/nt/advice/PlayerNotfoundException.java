package com.nt.advice;

public class PlayerNotfoundException extends RuntimeException {
	
	public PlayerNotfoundException() {
		super();
	}
	public PlayerNotfoundException(String msg) {
		super(msg);
	}

}
