package br.com.cast.main;

import br.com.cast.exceptions.NumeroDoQuartoRepetidoException;
import br.com.cast.exceptions.QuartoOcupadoException;
import br.com.cast.exceptions.QuartoVazioException;
import br.com.cast.interfaces.Faturavel;
import br.com.cast.models.abstracts.Quarto;
import br.com.cast.modelss.Andar;
import br.com.cast.modelss.Hospede;
import br.com.cast.modelss.Hotel;
import br.com.cast.modelss.QuartoCortesia;
import br.com.cast.modelss.QuartoLuxo;
import br.com.cast.modelss.QuartoSimples;
import br.com.cast.modelss.Recepcao;

public class Principal {
	private static String DESCRICAO_SIMPLES = "\n\t\tClimatização\r\n" + "\t\tTV: canais internacionais\r\n"
			+ "\t\tWi-Fi gratuito\r\n" + "\t\tAparelho de som c/ Bluetooth\r\n" + "\t\tTelefone\r\n" + "\t\tEscrivaninha\r\n"
			+ "\t\tMinibar como cortesia\r\n" + "\t\tCofre\r\n" + "\t\tSecador de cabelos\r\n" + "\t\tBandeja com cortesias\n\t";

	private static String DESCRICAO_LUXO = "\n\t\tClimatização\r\n" + "\t\tTV: canais internacionais\r\n"
			+ "\t\tWi-Fi gratuito\r\n" + "\t\tAparelho de som c/ Bluetooth\r\n" + "\t\tTelefone\r\n" + "\t\tEscrivaninha\r\n"
			+ "\t\tMinibar como cortesia\r\n" + "\t\tCofre\r\n" + "\t\tSecador de cabelos\r\n" 
			+ "\t\tBandeja com cortesias\r\n" + "\t\tCofre\r\n" + "\t\tPiscina\r\n"+ "\t\tBar da piscina\r\n" + "\t\tDeck da piscina\r\n" 
			+ "\t\tSpa&Massage\r\n";

	private static String DESCRICAO_CORTESIA = "2 camas de casal o 1 cama de casal e 2 camas individuais\r\n"
			+ "Wi-Fi de cortesia\r\n";

	public static void main(String[] args) {
		
		// Criar um objeto do tipo Hotel;
		Hotel h = new Hotel("Confort");

		System.out.println("\t\t\tBEM VINDO AO HOTEL CONFORT                            ¦");
	
		// Criar três objetos do tipo Andar;

		// Três objetos para QuartoSimples;
		QuartoSimples qS1 = new QuartoSimples("QuartoSimplexUm", DESCRICAO_SIMPLES);
		QuartoSimples qS2 = new QuartoSimples("QuartoSimplexDois", DESCRICAO_SIMPLES);
		QuartoSimples qS3 = new QuartoSimples("QuartoSimplexTres", DESCRICAO_SIMPLES);

		// Três objetos para QuartoLuxo;
		QuartoLuxo qL1 = new QuartoLuxo("QuartoLuxexUm", DESCRICAO_LUXO);
		QuartoLuxo qL2 = new QuartoLuxo("QuartoLuxexDois", DESCRICAO_LUXO);
		QuartoLuxo qL3 = new QuartoLuxo("QuartoLuxexTres", DESCRICAO_LUXO);

		// Dois objetos para QuartoCortesia;
		QuartoCortesia qC1 = new QuartoCortesia("QuartoCortex", "Colchonete" + "\n");
		QuartoCortesia qC2 = new QuartoCortesia("QuartoCortex", "Colchonete" + "\n");

		// Criar cinco objetos do tipo Hospede;
		Hospede b = new Hospede("Bianca", "12121212");
		Hospede l = new Hospede("Lucas", "21212121");
		Hospede j = new Hospede("Joao", "31313131");
		Hospede m = new Hospede("Maria", "41414141");
		Hospede p = new Hospede("Paulo", "51515151");

		// Adicionar dois hóspedes em um quarto simples cada
		System.out.println("------------------------------------------------------------------------------");
		try {
			qS1.adicionarHospede(p);
			System.out.println(p.toString() + " Adicionado com sucesso ao: " + qS1.getNome());
			qS2.adicionarHospede(m);
			System.out.println(m.toString() + " Adicionado com sucesso ao: " + qS2.getNome());
		} catch (QuartoOcupadoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("-----------------------------------------------------------------------------");
		// Adicionar dois hóspedes em um quarto de luxo cada
		try {
			qL1.adicionarHospede(l);
			System.out.println(l.toString() + " Adicionado com sucesso ao: " + qL1.getNome());
			qL2.adicionarHospede(b);
			System.out.println(b.toString() + " Adicionado com sucesso ao: " + qL2.getNome());
		} catch (QuartoOcupadoException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		// Adicionar o último hóspede em um quarto já ocupado acima;
		try {
			qS1.adicionarHospede(j);
			System.out.println(j.toString() + " Adicionado com sucesso ao: " + qS1.getNome());
		} catch (QuartoOcupadoException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println();
		// Adicionar os três andares no hotel;

		System.out.println();
		// Adicionar os dois quartos simples no primeiro andar;
		System.out.println("------------------------------------------------------------------------------");
		Andar a1 = new Andar(1);
		h.adicionarAndar(a1);
		System.out.println("------------------------------------------------------------------------------");
		try {
			a1.adicionarQuarto(11, qS1);
			System.out.println();
			a1.adicionarQuarto(12, qS2);
			System.out.println();
		} catch (NumeroDoQuartoRepetidoException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("------------------------------------------------------------------------------");
		// Adicionar um quarto simples e dois quartos cortesias no segundo andar
		Andar a2 = new Andar(2);
		h.adicionarAndar(a2);
		System.out.println("------------------------------------------------------------------------------");
		try {
			a2.adicionarQuarto(21, qS3);
			System.out.println();
			a2.adicionarQuarto(22, qC1);
			System.out.println();
			a2.adicionarQuarto(23, qC2);
			System.out.println();
		} catch (NumeroDoQuartoRepetidoException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("------------------------------------------------------------------------------");
		// Adicionar os três quartos de luxo no terceiro andar;
		Andar a3 = new Andar(3);
		h.adicionarAndar(a3);
		System.out.println("------------------------------------------------------------------------------");
		try {
			a3.adicionarQuarto(31, qL1);
			System.out.println();
			a3.adicionarQuarto(32, qL2);
			System.out.println();
			a3.adicionarQuarto(33, qL3);
			System.out.println();
		} catch (NumeroDoQuartoRepetidoException e) {
			System.err.println(e.getMessage());
		}
		
		// Invocar o método imprimeDados do hotel;
		h.imprimeDados();

		System.out.println();
		// teste remove
		try {
			qL3.removerHospede();
		} catch (QuartoVazioException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println();
		//Invocar o método pagar da Recepção para:
		//Um quarto simples com 8 diárias;
		//Um quarto de luxo com 4 diárias.
		System.out.println("Um quarto simples com 8 diárias");
		Recepcao.pagar(qS1, 8);
		System.out.println("Um quarto de luxo com 4 diárias");
		Recepcao.pagar(qL1, 4);

	}
}
