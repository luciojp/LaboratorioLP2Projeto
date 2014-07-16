package ufcg.cc.lp2.logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projetop2.utils.ArquivoDeDados;


/**
 * Classe que define um banco de dados que armazena todos os usuarios da aplicação.
 * @author Clenimar
 */
public class BancoDeDados{
	
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
	public boolean login(String email, String senha) throws Exception{
		if (email == null)
			throw new Exception("E-mail invalido!");
		if (senha == null)
			throw new Exception("Senha invalida!");
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
	 * Retorna um boolean indicando se um e-mail passado como parametro ja existe no BD!
	 * @author Clenimar
	 * @param email
	 * @return
	 */
	public boolean hasEmail(String email) throws Exception{
		if (pesquisaUsuario(email) != null)
			return true;
		return false;
	}
	/**
	 * Metodo para pesquisar usuarios no Banco de dados
	 * @author clenimar
	 * @param email
	 * @return o usuario, caso exista; ou null, caso nao
	 */
	
	public Usuario pesquisaUsuario(String email) throws Exception{
			if (email == null)
				throw new Exception("E-mail invalido!");
			
			Iterator<Usuario> it = getUsuarios().iterator();
			Usuario usuarioIt;
			while (it.hasNext()){
				usuarioIt = it.next();
				if (email.equals(usuarioIt.getEmail()))
					return usuarioIt;
			}
			return null;
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
	public boolean adicionarUsuario(Usuario usuario) throws Exception{
		if (usuario == null)
			throw new Exception("Usuario nulo!");
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
	public boolean carregar() throws Exception{
		if(arquivo.carregaObjetos() instanceof List<?>){
			bd.clear();
			Iterator<Usuario> it = arquivo.carregaObjetos().iterator();
			Usuario usuarioIt;
			while (it.hasNext()){
				usuarioIt = it.next();
				bd.add(usuarioIt);
			}
			return true;
		}
		return false;
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