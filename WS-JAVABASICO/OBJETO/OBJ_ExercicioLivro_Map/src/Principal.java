
public class Principal {

	public static void main(String[] args) {
		Autor a = new Autor("sabio", "sabido", "sabedor");
		Livro l = new Livro("Livro dos sabios", a,"10/10/1910", "sabidona");
		
		
		
		l.addPagina(new Pagina(1, "Primeira pagina"));
		l.addPagina(new Pagina(2, "Lorem Ipsum � simplesmente uma simula��o de texto da ind�stria tipogr�fica e de impressos, e vem sendo utilizado desde o s�culo XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu n�o s� a cinco s�culos, como tamb�m ao salto para a editora��o eletr�nica, permanecendo essencialmente inalterado. Se popularizou na d�cada de 60, quando a Letraset lan�ou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editora��o eletr�nica como Aldus PageMaker."));
		l.addPagina(new Pagina(3, " um fato conhecido de todos que um leitor se distrair� com o "
								+ "conte�do de texto leg�vel de uma p�gina quando estiver examinando sua diagrama��o. "
								+ "A vantagem de usar Lorem Ipsum � que ele tem uma distribui��o normal de letras, "
								+ "ao contr�rio de fazendo com que ele tenha uma apar�ncia similar a de um texto leg�vel"));
		
		l.imprimirLivro();
		
	}

}
