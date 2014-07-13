package ufcg.cc.lp2.logica;

import java.util.ArrayList;
import java.util.Iterator;

public class GerenteDeUsuarios  {
	private ArrayList<Pessoa> todosUsuarios;
	
	public GerenteDeUsuarios(String nome, String email, String senha1,
			String senha2, String dicaSenha) {

	}
	
	/**
	 * Adiciona Usuario para lista geral dos Usuarios , verifica se se o usuario passado é null , e a pessoa
	 * ja existe .  Se for verdadeira uma das opçoes lança exceçao.
	 *
	 * @author Nicolas Gabriel
	 * @param obj
	 * @throws Exception
	 */
	public void addUsuario(Object obj) throws Exception{
		if (!(obj instanceof Pessoa)) throw new Exception("Voce precisa adicionar um Objeto do tipo Usuario.");
		
		Pessoa novoUsuario = (Pessoa) obj;
		
		Iterator<Pessoa> it = todosUsuarios.iterator();
		Pessoa usuarioIt;
		while (it.hasNext()){
			usuarioIt = it.next();
			if (obj.equals(usuarioIt)){
				throw new Exception("Usuario Já existente.");
				
			}
		}

		
		todosUsuarios.add(novoUsuario);
	}
	
	/**
	 * Pesquisa Usuario Pelo email
	 * 
	 * @author Nicolas Gabriel
	 * @param email
	 * @return Descricao do Usuario , com nome e email
	 */
	
	public String pesquisaUsuario(String email){
		
		Iterator<Pessoa> it = todosUsuarios.iterator();
		Pessoa usuarioIt;
		while (it.hasNext()){
			usuarioIt = it.next();
			if (email.equals(usuarioIt.getEmail())){
				return usuarioIt.toString();
				
			}
		}
		
		return "Usuario Inexistente";

		
	}
}