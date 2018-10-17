package br.com.cast.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/img")
public class Imagens extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dirUpload = "C:\\imagens\\";
		String nomeDoArquivo = request.getParameter("arquivo");
		
		File file = new File(dirUpload + nomeDoArquivo);
		
		FileInputStream in = new FileInputStream(file);
		byte[] bytes = new byte[(int)file.length()];
		in.read(bytes);
		
		response.setContentType("image/jpeg");
		
		response.getOutputStream().write(bytes);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
