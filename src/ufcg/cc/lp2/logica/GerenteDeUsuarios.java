package ufcg.cc.lp2.logica;

import java.util.ArrayList;

public class GerenteDeUsuarios  {
	private ArrayList<Pessoa> todosUsuarios;
	
	public GerenteDeUsuarios(String nome, String email, String senha1,
			String senha2, String dicaSenha) {

	}
	
	public void addUsuario(Object obj) throws Exception{
		if (!(obj instanceof Pessoa)) throw new Exception("Voc� precisa adicionar um Objeto do tipo Usu�rio.");
		
		Pessoa novoUsuario = (Pessoa) obj;
		todosUsuarios.add(novoUsuario);
	}
}