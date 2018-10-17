package heranca.maquina;

public class ProdutoIndisponivelException extends Exception{
	
	public ProdutoIndisponivelException() {
		super("Produto Indisponivel!");
	}
}
