package br.com.tiago.util;


public class ErroSistema extends Exception {


	private static final long serialVersionUID = 1L;
	
	
	public ErroSistema(String msg) {
		super(msg);
	}
	
	public ErroSistema(String msg, Throwable causa) {
		super(msg, causa);
	}
	
}
