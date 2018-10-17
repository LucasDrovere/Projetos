package br.com.cast.conta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cast.conta.modelo.Conta;
import br.com.cast.conta.persistencia.DaoConta;

@WebServlet("/cadastrar")
public class CadastroDeContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isAlteracao = Boolean.parseBoolean(
				request.getParameter("isAlteracao"));
		
		String numero = request.getParameter("numero");
		String saldo = request.getParameter("saldo");
		
		Conta conta = new Conta();
		conta.setNumero(numero);
		conta.setSaldo(Double.parseDouble(saldo));
		
		DaoConta dao = new DaoConta();
		
		if (isAlteracao) {
			dao.alterar(conta);
		} else {
			dao.inserir(conta);
		}
		
		//informa ao browser que deverá ser feito um redirecionamento
		response.sendRedirect("/conta-jsp/listar-conta.jsp");
		
	}

}
