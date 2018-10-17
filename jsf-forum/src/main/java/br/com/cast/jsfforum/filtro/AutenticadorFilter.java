package br.com.cast.jsfforum.filtro;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cast.jsfforum.managedbean.LoginController;



public class AutenticadorFilter implements Filter {

	private List<String> permitidas;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Inicializando Segurança filter...");
		// pass the request along the filter chain

		HttpServletRequest servletRequest = (HttpServletRequest) request;

		String url = servletRequest.getRequestURL().toString();

		System.out.println("url " + url);
		boolean isPaginaPermitida = false;

		for (String pagina : permitidas) {
			if (url.endsWith(pagina)) {
				isPaginaPermitida = true;
				break;
			}
		}

		if (isPaginaPermitida) {
			// liberado para essas urls!
			chain.doFilter(request, response);
		} else {
			HttpSession session = servletRequest.getSession();
			
			LoginController seguranca = (LoginController) session.getAttribute("login");
			if (seguranca == null || !seguranca.isLogado()) {
				// retorna o html de login
				request.getRequestDispatcher("login.xhtml").forward(request, response);
			} else {
				// segue o fluxo!
				chain.doFilter(request, response);
			}

			System.out.println("Finalizando Segurança filter...");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String paginas = fConfig.getInitParameter("paginasPermitidas");
		permitidas = Arrays.asList(paginas.split(","));
		System.out.println("Páginas permitidas " + permitidas);
	}

}
