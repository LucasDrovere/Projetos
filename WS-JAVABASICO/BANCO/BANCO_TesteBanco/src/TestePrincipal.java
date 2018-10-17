import java.sql.SQLException;
import java.util.List;



import Persistencia.DAOFilme;
import Persistencia.Filme;

public class TestePrincipal {

	public static void main(String[] args) throws SQLException {
		
		DAOFilme daoFilme = new DAOFilme();
		
		List<Filme> filmes = daoFilme.buscarTodos();
		
		percorreFilmes(filmes);
		
		//insere filmes
		/*Filme simp = new Filme();
		simp.setNome("Os Simpsons");
		simp.setAno(2000);
		daoFilme.insereFilmes(simp);*/
		
		daoFilme.excluiFilmes(5);
		
		
		
	}

	public static void percorreFilmes(List<Filme> filmes) {
		for(Filme f : filmes) {
			System.out.println(f);
		}
	}
}
