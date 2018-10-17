package br.com.cast.jsfintro.servlet;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cast.jsfintro.business.AlunoBusiness;
import br.com.cast.jsfintro.dto.AlunoDTO;


@WebServlet("/Salvar")
public class Salvar extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//recupera a string json da requisição
				String json = request.getReader()
						.lines().collect(Collectors.joining());
				
				Gson gson = new Gson();
				AlunoDTO alunoDto = gson.fromJson(json, AlunoDTO.class);
				
				AlunoBusiness alnB = new AlunoBusiness();
				alnB.salvar(alunoDto);
				
				System.out.println(alunoDto);
	}

}
