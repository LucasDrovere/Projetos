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

import br.com.cast.entidade.Arq;
import br.com.cast.persistencia.upDAO;

@WebServlet("/up")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 4, // 4MB
		maxRequestSize = 1024 * 1024 * 4 // 4MB
)
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SAVE_DIR = "C:\\Imagens\\";

	
	upDAO up = new upDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Arq a = new Arq();
		
		String dir = SAVE_DIR;
        
        Part part = request.getPart("meuArquivo");
        
        String arquivoOriginal = Paths.get(part.getSubmittedFileName()).toString();
        
        String extensao = arquivoOriginal.substring(arquivoOriginal.indexOf("."));
        
        String nomeArquivo = UUID.randomUUID().toString() + extensao;

        part.write(dir + nomeArquivo);
  
        
        a.setName(nomeArquivo);
        a.setDir(dir + nomeArquivo);
        up.inserir(a);
        
        response.sendRedirect("upload.jsp");
    }
}
