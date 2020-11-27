package com.capgemini.gos.exceptions;

@SuppressWarnings("serial")

public class ProductDoesNotExistException extends Exception {
		public  ProductDoesNotExistException(String errorMsg){
			super(errorMsg);
		}
		public  ProductDoesNotExistException(){
             super();
		}
}
