public class Anotacoes {

	/*
	 
	*número, privado, estático e constante * = private static final double
	*alterar o construtor padrão para privado* = private nomeDaClasse() {}
	
	
	--------------------------------------------------------------------------------------------------------------------
	/\/\ MAP /\/\
	*declaração da variavel * = private Map<TIPO DA CHAEVE, TIPO DO VALOR> NOMEDOMAPA;
	*iniciar o mapa* *exemplo dentro do construtor* = this.NOMEDOMAPA = new HashMap<>();
	*inserir dentro do metodo no mapa* = mapaDeQuartos.put(TIPO DA CHAEVE, TIPO DO VALOR);
	*pegar a chave dentro do mapa de chaves* = Quarto quarto = mapaDeQuartos.get(TIPO DA CHAEVE);
	*mostrar mapa* = System.out.println(NOMEDOMAPA);
	--------------------------------------------------------------------------------------------------------------------
	/\	LIST /\
	*declaração da variavel * = private List<Andar> andares;
	*iniciar o mapa* *exemplo dentro do construtor* = andares = new ArrayList<>();
	*adicionar dentro da list* = andares.add(a);
	
	*FOREACH*
	for (TIPODOARRAY nomedavariavel : NOMEDALISTA) {
			System.out.println(nomedavariavel.getNome() + " " + nomedavariavel.getSobrenome());
		}
	--------------------------------------------------------------------------------------------------------------------
	 /\/\ EXCEPTION /\/\
	**declaraçõa na classe**
	class extends Exception {
	
	public nomeDaException() {
	super("Mensagem do erro");
	}
	
	**declaração no metodo**
	public void nomeDoMetodo(parametros) throws nomeDaException{}
	no corpo do metodo usar no erro: throw new nomeDaException();
	
	**na classe que for chamar o metodo e tratar o mesmo**
	try{
	nomeDoMetodo("teste");
		}catch (nomeDaException e){
			System.err.println(e.getMessage());
		}
	
	--------------------------------------------------------------------------------------------------------------------
	/\/\ INTERFACE /\/\
	**declaração na interface**
	declarar um metodo e utilizar o mesmo em todas as classes
	que implementarem a mesma interface
	
	*class Faturavel*
	public interface Faturavel {
	public double faturar(int qntDeDiarias);
	}
	
	*class que implementa Faturavel*
	@Override
	public double faturar(int qntDeDiarias) {
		return qntDeDiarias * VALOR_DIARIA;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	*/
	
}
