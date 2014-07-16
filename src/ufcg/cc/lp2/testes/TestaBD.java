package ufcg.cc.lp2.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ufcg.cc.lp2.logica.*;

public class TestaBD {
	
	private BancoDeDados bd;
	public Usuario rijkaard, gullit, neeskens;
	
	@Before
	public void criaBD() throws Exception{
		bd = new BancoDeDados();
		rijkaard = new Usuario("Rijkaard", "rijkaard@hotmail.com", "robben", "robben", "love of my life");
		gullit = new Usuario("Ruud Gullit", "ruud@gmail.com", "imdabst", "imdabst", "the truth");
		neeskens = new Usuario("Neeskens", "nees13@gmail.com", "cruijfff", "cruijfff", "the best");
		
	}
	
	@Test
	public void testaCriaBD(){
		Assert.assertTrue(bd != null);
		
	}
	
	@Test
	public void bateriaUm() throws Exception{
		/*
		 * Testa métodos:
		 * adicionarUsuario(), removerUsuario(), hasEmail(), 
		 * pesquisaUsuario() e getUsuarios()
		 */
		try{
			bd.adicionarUsuario(null);
			Assert.fail();
		} catch (Exception e){
			Assert.assertEquals("Mensagem errada", "Usuario nulo!", e.getMessage());
		}
		
		bd.adicionarUsuario(rijkaard);
		Assert.assertTrue(bd.hasEmail(rijkaard.getEmail()));
		bd.adicionarUsuario(neeskens);
		Assert.assertTrue(bd.hasEmail(neeskens.getEmail()));
		Assert.assertTrue(bd.getUsuarios().size() == 2);
		bd.removerUsuario(neeskens);
		Assert.assertTrue(bd.getUsuarios().size() == 1);
		Assert.assertFalse(bd.hasEmail(neeskens.getEmail()));
		Assert.assertEquals(rijkaard, bd.pesquisaUsuario("rijkaard@hotmail.com"));
		
		try {
			bd.pesquisaUsuario(null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "E-mail invalido!", e.getMessage());
		}
	}
		
		@Test
		public void bateriaDois() throws Exception{
			/*
			 * Testa método login()
			 */
			
			bd.adicionarUsuario(gullit);
			Assert.assertFalse(bd.login("ruud@gmail.com", "senhaErrada"));
			Assert.assertFalse(bd.login("emailqualquer@ig.com", "imdabst"));
			Assert.assertTrue(bd.login("ruud@gmail.com", "imdabst"));
			Assert.assertFalse(bd.login("cacarato7@hotmail.com", "soucr7"));
			bd.removerUsuario(gullit);
			Assert.assertFalse(bd.login("ruud@gmail.com", "imdabst"));
			
			try{
				bd.login(null, "senhaQlqr");
				Assert.fail();
			} catch (Exception e){
				Assert.assertEquals("Mensagem errada", "E-mail invalido!", e.getMessage());
			}
			
			try{
				bd.login("email@ccc.ufcg.edu.br", null);
				Assert.fail();
			} catch (Exception e) {
				Assert.assertEquals("Mensagem errada", "Senha invalida!", e.getMessage());
			}
			
	}
		
	@Test
	public void bateriaTres() throws Exception{
		bd.adicionarUsuario(gullit);
		bd.adicionarUsuario(rijkaard);
		bd.adicionarUsuario(neeskens);
		
		try {
			bd.salvar();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
