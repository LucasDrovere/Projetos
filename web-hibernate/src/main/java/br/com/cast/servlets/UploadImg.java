package br.com.cast.servlets;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.cast.entidade.Imagem;
import br.com.cast.entidade.Post;
import br.com.cast.persistencia.PostDao;

@WebServlet("/upload-img")
@MultipartConfig
public class UploadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostDao pstDao = new PostDao();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dirUpload = "C:\\imagens\\";
		
		String texto = request.getParameter("texto");
		
		System.out.println(texto);
		
		Part part = request.getPart("meuArquivo");
		String arquivoOriginal = 
				Paths.get(part.getSubmittedFileName())
				.toString();
		
		String extensao = arquivoOriginal
				.substring(arquivoOriginal.lastIndexOf("."));
		
		String nomeArquivo = UUID.randomUUID().toString() 
				+ extensao;
		part.write(dirUpload + nomeArquivo);
		
		
		Post pst = new Post();
		pst.setTexto(request.getParameter("texto"));
		Imagem img = new Imagem();
		img.setArquivo(nomeArquivo);
		pst.addImagem(img);
		pstDao.inserir(pst);

		response.sendRedirect("inicio.jsp");
		pstDao.fechar();
		
	}

}
