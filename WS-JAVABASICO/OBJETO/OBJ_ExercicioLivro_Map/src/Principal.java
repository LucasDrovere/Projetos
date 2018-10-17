
public class Principal {

	public static void main(String[] args) {
		Autor a = new Autor("sabio", "sabido", "sabedor");
		Livro l = new Livro("Livro dos sabios", a,"10/10/1910", "sabidona");
		
		
		
		l.addPagina(new Pagina(1, "Primeira pagina"));
		l.addPagina(new Pagina(2, "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker."));
		l.addPagina(new Pagina(3, " um fato conhecido de todos que um leitor se distrairá com o "
								+ "conteúdo de texto legível de uma página quando estiver examinando sua diagramação. "
								+ "A vantagem de usar Lorem Ipsum é que ele tem uma distribuição normal de letras, "
								+ "ao contrário de fazendo com que ele tenha uma aparência similar a de um texto legível"));
		
		l.imprimirLivro();
		
	}

}
