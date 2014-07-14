package ufcg.cc.lp2.logica;

public class GerenteDeUsuarios  {
	private BancoDeDados bd = new BancoDeDados();
	
	public GerenteDeUsuarios(String nome, String email, String senha1, String senha2, String dicaSenha) {
		
	}
	
	/**
	 * Adiciona um usuario ao banco de dados, caso ele nao exista.
	 * @author Clenimar
	 * @param Os atributos do novo usuario
	 * @throws Exception, caso a criacao do novo usuario seja invalidada
	 */
	public void addUsuario(String nome, String email, String senha1, String senha2, String dicaSenha) throws Exception{
		Usuario usuario = new Usuario(nome, email, senha1, senha2, dicaSenha);
		bd.adicionarUsuario(usuario);
	}
	
	/**
	 * Pesquisa Usuario Pelo email
	 * 
	 * @author Nicolas Gabriel
	 * @param email
	 * @return Descricao do Usuario , com nome e email
	 */
	
	public Usuario pesquisaUsuario(String email){
		return bd.pesquisaUsuario(email);
	}
}