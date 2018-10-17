
public class Principal {

	public static void main(String[] args) {
		Empresa emp = new Empresa("Cast-Group");

		emp.addFuncionario(new ProgramadorJunior("Pedro"));
		emp.addFuncionario(new ProgramadorJunior("Maria"));
		emp.addFuncionario(new Estagiario("Joao"));
		
		emp.listarFuncionarios();
	}

}

