package br.com.cast.blog;

import java.util.Date;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import br.com.cast.entidade.Post;

public class TestCase extends junit.framework.TestCase {
	
	
	/*public void testInserirPost() {
		Post post = new Post();
		
		post.setTexto("Teste bla bla");
		post.setData(new Date());
		
		Imagem img1 = new Imagem();
		img1.setArquivo("casa.jpg");
		post.addImagem(img1);
		
		Imagem img2 = new Imagem();
		img2.setArquivo("garota.jpg");
		post.addImagem(img2);
		
		Imagem img3 = new Imagem();
		img3.setArquivo("sol.jpg");		
		post.addImagem(img3);
		
		PostDao dao = new PostDao();		
		dao.inserir(post);
		
		assertTrue(post.getId() != null);
	}*/
	
	/*public void testExclusao() {
		
		PostDao dao = new PostDao();
		
		Post post = dao.buscarPorId(8);
		
		Imagem imgSol = new Imagem();
		imgSol.setId(22);
		
		post.setTexto("abc!");
		post.removeImagem(imgSol);
		
		EntityTransaction transaction = dao.getEntityManager().getTransaction();
		
		transaction.begin();
		transaction.commit();
		
	}*/
	
	/*public void testMerge() {
		
		PostDao dao = new PostDao();
		Post post = dao.buscarPorId(8);
		//fecha o entityManager
		dao.fechar();
		
		//cria um novo entityManager onde o post não é gerenciado
		dao = new PostDao();
		
		EntityManager em = dao.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			post.setTexto("aaaaa");
			em.merge(post);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}*/
	
	public void testValicoes() {
		
		Post post = new Post();
		post.setData(new Date());
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
		
	}
	

}
