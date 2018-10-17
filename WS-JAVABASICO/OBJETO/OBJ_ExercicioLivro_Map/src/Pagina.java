public class Pagina implements Comparable<Pagina>{

	private int numero;
	private String texto;
	
	public Pagina(int numero, String texto) {
		this.numero = numero;
		this.texto = texto;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Numero da pagina: " + numero + "" + "> \nTexto da pagina: " + texto + "";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagina other = (Pagina) obj;
		if (numero != other.numero)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}
	@Override
	public int compareTo(Pagina outraPagina) {
		int stringCompare = texto.compareToIgnoreCase(
				outraPagina.getTexto());
	return stringCompare * -1;
	}

	
}
