package ufcg.cc.lp2.logica;

import java.io.Serializable;


public class Usuario extends Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario(String nome, String email, String senha1, String senha2,
			String dicaSenha) throws Exception {
		super(nome, email, senha1, senha2, dicaSenha);
	}

}
