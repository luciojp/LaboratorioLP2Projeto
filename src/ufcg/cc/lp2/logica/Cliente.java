package ufcg.cc.lp2.logica;

import projetop2.utils.ArquivoDeDados;

public class Cliente extends Usuario{

	public Cliente(String nome, String email, String senha1, String senha2,
			String dicaSenha) throws Exception {
		super(nome, email, senha1, senha2, dicaSenha);
	}

}
