package forum.servlet;

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

import forum.entidade.Critica;
import forum.entidade.Imagem;
import forum.persistencia.CriticaDao;

@WebServlet("/Alterar")
@MultipartConfig
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dirUpload = "C:\\imagens\\";
		
		Part part = request.getPart("file");
	
		String arquivoOriginal = Paths.get(part.getSubmittedFileName()).toString();
		
		String extensao = arquivoOriginal.substring(arquivoOriginal.lastIndexOf("."));
		
		String nomeArquivo = UUID.randomUUID().toString() + extensao;
		part.write(dirUpload + nomeArquivo);
		
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		CriticaDao dao = new CriticaDao();
		
		Critica c = dao.buscarPorId(id);
		c.setTitulo(titulo);
		c.setDescricao(descricao);
		
		Imagem img = new Imagem();
		img.setCaminho(nomeArquivo);
		c.addImagem(img);
		
		dao.alterar(c);
		
		response.sendRedirect("/forum/listar-criticas.jsp?numPagina=1");
	}

}
