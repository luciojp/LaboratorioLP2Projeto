package ufcg.cc.lp2.logica;

import projetop2.utils.ArquivoDeDados;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que define um banco de dados que armazena todos os usuarios da aplicação.
 * @author Clenimar
 */
public class BancoDeDados {
	
	private List<Usuario> bd;
	private ArquivoDeDados<List<Usuario>> arquivo = new ArquivoDeDados<List<Usuario>>("bd.txt");
	
	/**
	 * Cria um novo banco de dados, que se comunica com a biblioteca projetoHelper e com as demais
	 * camadas da aplicação, através de uma ArrayList<Usuario>().
	 */
	public BancoDeDados(){
		bd = new ArrayList<Usuario>();
	}
	
	/**
	 * Efetua login no sistema, comunicando-se com o banco de dados
	 * 
	 * @author clenimar
	 * @param email
	 * @param senha
	 * @return o sucesso ou nao da operacao
	 */
	public boolean login(String email, String senha){
		Iterator<Usuario> it = bd.iterator();
		Usuario usuarioIt;
		while (it.hasNext()){
			usuarioIt = it.next();
			if (email.equals(usuarioIt.getEmail())){
				if (senha.equals(usuarioIt.getSenha()))
					return true;
			}
		}
		return false;		
	}
	
	/**
	 * @author clenimar
	 * @return a List<Usuario> de usuarios
	 */
	public List<Usuario> getUsuarios(){
		return bd;
	}
	
	/**
	 * Adiciona um usuario a a lista de usuarios
	 * @author clenimar
	 * @param usuario
	 * @return o sucesso ou nao da operacao
	 */
	public boolean adicionarUsuario(Usuario usuario){
		return bd.add(usuario);
	}
	
	/**
	 * Remove um usuario da lista de usuarios, caso exista
	 * @author clenimar
	 * @param usuario
	 * @return o sucesso ou nao da operacao
	 */
	public boolean removerUsuario(Usuario usuario){
		return bd.remove(usuario);
	}
	
	/**
	 * Salvar a lista de usuarios no banco de dados
	 * @author clenimar
	 * @throws Exception
	 */
	public void salvar() throws Exception{
		arquivo.salvaObjeto(bd);
	}
	
	/**
	 * Carrega a lista de usuarios do banco de dados
	 * @author clenimar
	 * @return a lista de usuarios
	 * @throws Exception
	 */
	public List<Usuario> carregar() throws Exception{
		return arquivo.carregaObjetos();
	}
	
	/** Limpa o banco de dados
	 * @author clenimar
	 * @return
	 * @throws Exception
	 */
	public boolean resetar() throws Exception{
		return arquivo.limpaArquivo();
	}

}