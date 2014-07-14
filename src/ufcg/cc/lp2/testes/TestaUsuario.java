package ufcg.cc.lp2.testes;

import org.junit.Assert;
import org.junit.Test;

import ufcg.cc.lp2.logica.Usuario;

public class TestaUsuario {

	Usuario cliente;

	@Test
	public void criaClienteValido() throws Exception{
		
		cliente = new Usuario("Fulano", "fulano@gmail.com", "essaAi", "essaAi", "umaAi");
		Assert.assertEquals(true, cliente.validado);
		
	}
	
	@Test
	public void testaCliente() {
		
		
		try {
			cliente = new Usuario(null, "fulano@gmail.com", "essaAi", "essaAi", "umaAi");
			Assert.fail("Esperava excecao pois o nome eh invalido");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Nome invalido.", e.getMessage());
		}
		
		try {
			cliente = new Usuario("    ", "fulano@gmail.com", "essaAi", "essaAi", "umaAi");
			Assert.fail("Esperava excecao pois o nome eh invalido");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Nome invalido.", e.getMessage());
		}
		
		try {
			cliente = new Usuario("Lucio", "fulano@gmail.com", "essa", "essa", "umaAi");
			Assert.fail("Esperava excecao pois a senha eh muito curta");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Tamanho da senha invalido.", e.getMessage());
		}
		
		try {
			cliente = new Usuario("", "fulano@gmail.com", "essaAi", "essaAi", "umaAi");
			Assert.fail("Esperava excecao pois o nome eh invalido");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Nome invalido.", e.getMessage());
		}
		
		try {
			cliente = new Usuario("Fulano", "Hu3Hu3", "essaAi", "essaAi", "umaAi");
			Assert.fail("Esperava excecao pois o email eh invalido");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Email invalido", e.getMessage());
		}
		
		try {
			cliente = new Usuario("Fulano", "fulano@gmail.com", "essaAi", "essaAi", "essaAi");
			Assert.fail("Esperava excecao pois a dica eh igual a senha");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "A dica nao deve ser igual a senha.", e.getMessage());
		}
		
		try {
			cliente = new Usuario("Fulano", "fulano@gmail.com", "essaAi", "essaAis", "umaAi");
			Assert.fail("Esperava excecao pois as senhas nao coincidem.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Senhas nao coincidem.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaToString() throws Exception{
		
		cliente = new Usuario("Fulano", "Fulano@gmail.com", "essaAi", "essaAi", "umaAi");
		Assert.assertEquals("Nome: Fulano\nE-mail: Fulano@gmail.com", cliente.toString());
		
	}
	
	
}
