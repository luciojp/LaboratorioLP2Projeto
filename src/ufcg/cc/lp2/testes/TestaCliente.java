package ufcg.cc.lp2.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ufcg.cc.lp2.logica.Cliente;

public class TestaCliente {

	Cliente cliente;

	@Test
	public void testaCriaCliente() {

		try {
			cliente = new Cliente("Lucio", "fulano@gmail.com", "essa", "essa", "umaAi");
			Assert.fail("Esperava excessao pois a senha eh muito curta");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Tamanho da senha invalido.", e.getMessage());
		}
		
		try {
			cliente = new Cliente("", "fulano@gmail.com", "essaAi", "essaAi", "umaAi");
			Assert.fail("Esperava excessao pois o nome eh invalido");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Nome invalido.", e.getMessage());
		}
		
		try {
			cliente = new Cliente("Fulano", "Hu3Hu3", "essaAi", "essaAi", "umaAi");
			Assert.fail("Esperava excessao pois o email eh invalido");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Email invalido", e.getMessage());
		}
		
		try {
			cliente = new Cliente("Fulano", "fulano@gmail.com", "essaAi", "essaAi", "essaAi");
			Assert.fail("Esperava excessao pois a dica eh igual a senha");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "A dica nao deve ser igual a senha.", e.getMessage());
		}
		
	}
	
	
	
}
