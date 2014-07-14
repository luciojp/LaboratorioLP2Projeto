package ufcg.cc.lp2.logica;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome, email, senha1, dicaSenha;
	public BancoDeDados banco;

	/**
	 * @Autor Antonio Lucio - Apenas criacao do construtor e geracao dos gets and sets - 09/07/2014 - 20:14
	 * @param nome, nome do usuario
	 * @param email, email do usuario
	 * @param senha1, primeira senha para validacao
	 * @param senha2, segunda senha para comparar com a primeira
	 * @param dicaSenha, dica de senha caso se esqueca da senha
	 */
	public Pessoa(String nome, String email, String senha1, String senha2,
			String dicaSenha) throws Exception {
		checaNome(nome);
		checaEmail(email);
		checaTamanhoSenha(senha1);
		checaSenhasIguais(senha1, senha2);
		checaDicaSenha(senha1, dicaSenha);
		emailJaCadastrado(email);
		this.nome = nome;
		this.email = email;
		this.senha1 = senha1;
		this.dicaSenha = dicaSenha;
	}

	/**
	 * @author IgorNatanael
	 * @param nome
	 * O m�todo checa se o nome � v�lido
	 * 
	 * !! clenimar: acho que se nome for null vai estourar por NullPointerException
	 * 				vê isso, Lucio.
	 */
	private boolean checaNome(String nome) throws Exception{
		if (nome == null || nome.equals("") || checaEntradaEmBranco(nome))
			throw new Exception("Nome invalido.");
		return true;
	}

	/**
	 * Testa o tamanho da senha.
	 * @author Grupo
	 * @param senha
	 */
	private boolean checaTamanhoSenha(String senha) throws Exception{
		if (senha == null)
			throw new Exception("Senha invalida!");
		else if (checaEntradaEmBranco(senha))
			throw new Exception("Senha invalida!");
		else if (senha.length() < 6 || senha.length() > 8) {
			throw new Exception("Tamanho da senha invalido.");
		}
		return true;
	}
	/**@author Grupo
	 * Checa se a senha eh igual a confirmacao de senha
	 * @param senha1
	 * @param senha2
	 * @return true caso seja valido, caso contrario lanca uma excecao
	 * @throws Exception
	 */
	private boolean checaSenhasIguais(String senha1, String senha2) throws Exception{
		if (senha2 == null)
			return false;
		if (!(senha1.equals(senha2))) {
			throw new Exception("Senhas nao coincidem.");
		}
		return true;
	}
	
	/**@author Grupo
	 * Checa se a dica de senha eh igual a senha
	 * @param senha
	 * @param dica
	 * @return true se a dica for diferente da senha, caso contrario lanca uma excecao
	 * @throws Exception
	 */
	private boolean checaDicaSenha(String senha, String dica) throws Exception{
		if (dica == null)
			throw new Exception("Dica invalida!");
		if (checaEntradaEmBranco(dica))
			throw new Exception("Dica invalida!");
		if (dica.equals(senha)){
			throw new Exception("A dica nao deve ser igual a senha.");
		}
		return true;
	}
	
	/**@author Grupo
	 * Checa se o email eh valido.
	 * @param email
	 * @return true se for valido
	 */
	private boolean checaEmail(String email) throws Exception{
		if (email == null)
			throw new Exception("Email invalido");
		String regex = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+";   
		boolean ok = email.matches(regex); 
		if(ok == false){
			throw new Exception("Email invalido");
		}
		if (emailJaCadastrado(email))
			throw new Exception("Email ja utilizado!");
		return ok;
	}
	
	/**
	 * @author clenimar
	 * @param s
	 * @return se a string passada como parametro eh composta apenas por espacos em branco
	 */
	private boolean checaEntradaEmBranco(String s){
		int tam = s.length();
		for (int i = 0; i < tam; i++){
			if (!Character.isWhitespace(s.charAt(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * @author clenimar
	 * @param email
	 * @return se um email ja esta na base de dados
	 */
	private boolean emailJaCadastrado(String email) throws Exception{
		//tem que implementar isso ainda
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha1;
	}

	public void setSenha(String senha1) {
		this.senha1 = senha1;
	}

	public String getDicaSenha() {
		return dicaSenha;
	}

	public void setDicaSenha(String dicaSenha) {
		this.dicaSenha = dicaSenha;
	}
	
	/**
	 * @author clenimar
	 */
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Pessoa))
			return false;
		Pessoa outro = (Pessoa) o;
		
		return (this.getEmail().equals(outro.getEmail()));
			}
	
	/**
	 * @author clenimar
	 */
	@Override
	public String toString(){
		return "Nome: " + this.getNome() + "\nE-mail: " + this.getEmail();
	}

}