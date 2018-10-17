package br.com.cast.jsfintro.business;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cast.jsfintro.dto.UsuarioDTO;
import br.com.cast.jsfintro.entidade.Usuario;
import br.com.cast.jsfintro.persistencia.UsuarioDao;

public class UsuarioBusiness {

	private UsuarioDao usuariodao;

	public UsuarioBusiness() {
		this.usuariodao = new UsuarioDao();
	}

	public String salvar(UsuarioDTO UsuarioDTO) {

		Usuario u = buscarUser(UsuarioDTO.getUsuario(), UsuarioDTO.getSenha());

		if (u == null) {
			Usuario usuario = new Usuario();
			usuario.setNome(UsuarioDTO.getNome());
			usuario.setUsuario(UsuarioDTO.getUsuario());
			usuario.setSenha(UsuarioDTO.getSenha());
			usuariodao.inserir(usuario);
			return "login";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuário " + u.getUsuario() + " ja existente!", "Erro no c!"));
		}
		return "cadastro-usuario";
	}

	public Usuario buscarUser(String usuario, String senha) {
		Usuario user = usuariodao.buscarUser(usuario, senha);
		return user;
	}

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

}
