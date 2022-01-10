package com.ingsoftware.gameachievements.exception;

public class BaseException extends Exception {

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, boolean enableSuppression, boolean writableStackTrace) {
		super(message, null, enableSuppression, writableStackTrace);
	}

}
