package exercicio5;

import java.util.ArrayList;
import java.util.List;

public class Casa {

	private String donoDaCasa;
	private List<Quarto> quartos;

	public Casa(String donoDaCasa) {
		this.donoDaCasa = donoDaCasa;
		quartos = new ArrayList<>();
	}

	public void adicionarQuarto(Quarto q) throws QuartoExistenteException {
		if (quartos.contains(q)) {
			throw new QuartoExistenteException();
		}
		quartos.add(q);
	}

	@Override
	public String toString() {
		return "Casa do(a): " + donoDaCasa + " tem os quarto(s): \n" + quartos;
	}
}
