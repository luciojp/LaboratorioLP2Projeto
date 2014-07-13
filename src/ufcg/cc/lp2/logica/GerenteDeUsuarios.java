package ufcg.cc.lp2.logica;

import java.util.ArrayList;

public class GerenteDeUsuarios  {
	private ArrayList<Usuario> todosUsuarios;
	
	public GerenteDeUsuarios(String nome, String email, String senha1,
			String senha2, String dicaSenha) {

	}
	
	public void addUsuario(Object obj) throws Exception{
		if (!(obj instanceof Usuario)) throw new Exception("Você precisa adicionar um Objeto do tipo Usuário.");
		
		Usuario novoUsuario = (Usuario) obj;
		todosUsuarios.add(novoUsuario);
	}
}
