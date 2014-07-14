package ufcg.cc.lp2.testes;

import junit.framework.Assert;

import org.junit.Test;

import ufcg.cc.lp2.logica.GerenteDeUsuarios;
import ufcg.cc.lp2.logica.Usuario;

public class TestaGerente {
	
	GerenteDeUsuarios gerente;
	Usuario cliente;
	
	@Test
	public void testaUsuarioExistente(){
		
		try {
			gerente = new GerenteDeUsuarios("gerente", "gerente@gmail.com", "123456", "123456", "umaAi");
			cliente = new Usuario("cliente1", "cliente1@gmail.com", "1234567", "1234567", "outraAi");
			gerente.addUsuario("cliente1", "cliente1@gmail.com", "1234567", "1234567", "outraAi");
			gerente.addUsuario("cliente1", "cliente1@gmail.com", "1234567", "1234567", "outraAi");
			Assert.fail("Esperava excecao, pois nao pode adicionar um cliente igual.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Usuario existente.", e.getMessage());
		}
		
	}
	
	@Test
	public void pesquisaUsuario() throws Exception{
		
		gerente = new GerenteDeUsuarios("gerente", "gerente@gmail.com", "123456", "123456", "umaAi");
		cliente = new Usuario("cliente1", "cliente1@gmail.com", "1234567", "1234567", "outraAi");
		gerente.addUsuario("cliente1", "cliente1@gmail.com", "1234567", "1234567", "outraAi");
		Assert.assertEquals("cliente1 ", gerente.pesquisaUsuario("cliente1@gmail.com"));
		
		
	}

}
