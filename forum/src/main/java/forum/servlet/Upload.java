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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import forum.entidade.Critica;
import forum.entidade.Imagem;
import forum.entidade.Usuario;
import forum.persistencia.CriticaDao;


/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload-img")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dirUpload = "C:\\imagens\\";
		
		Part part = request.getPart("file");
	
		String arquivoOriginal = Paths.get(part.getSubmittedFileName()).toString();
		
		String extensao = arquivoOriginal.substring(arquivoOriginal.lastIndexOf("."));
		
		String nomeArquivo = UUID.randomUUID().toString() + extensao;
		part.write(dirUpload + nomeArquivo);
		
		HttpSession session = request.getSession();
		CriticaDao dao = new CriticaDao();
		Usuario us =  (Usuario) session.getAttribute("usuarios");
		
		
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		
		Critica critica = new Critica();
		critica.setTitulo(titulo);
		critica.setDescricao(descricao);
		critica.setUsuario(us);
		
		Imagem img = new Imagem();
		img.setCaminho(nomeArquivo);
		critica.addImagem(img);
		
			
		dao.addCritica(critica);
		
		response.sendRedirect("/forum/listar-criticas.jsp?numPagina=1");
		
	}

}
