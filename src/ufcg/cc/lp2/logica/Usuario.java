package ufcg.cc.lp2.logica;

public class Usuario extends Pessoa{
	
	private BancoDeDados bd = new BancoDeDados();

	public Usuario(String nome, String email, String senha1, String senha2,
			String dicaSenha) throws Exception {
		super(nome, email, senha1, senha2, dicaSenha);
		bd.adicionarUsuario(this);
	}

}
