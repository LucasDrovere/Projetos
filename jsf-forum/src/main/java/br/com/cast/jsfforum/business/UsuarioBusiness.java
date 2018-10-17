package br.com.cast.jsfforum.business;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.cast.jsfforum.dto.UsuarioDTO;
import br.com.cast.jsfforum.entidade.Usuario;
import br.com.cast.jsfforum.persistencia.UsuarioDao;


public class UsuarioBusiness {

	private UsuarioDao usuariodao;

	public UsuarioBusiness() {
		this.usuariodao = new UsuarioDao();
	}

	public void salvar(UsuarioDTO UsuarioDTO) {

		Usuario u = buscarUser(UsuarioDTO.getUsuario(), UsuarioDTO.getSenha());

		if (u == null) {
			Usuario usuario = new Usuario();
			usuario.setNome(UsuarioDTO.getNome());
			usuario.setUsuario(UsuarioDTO.getUsuario());
			usuario.setSenha(UsuarioDTO.getSenha());
			usuariodao.inserir(usuario);

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Usuário " + u.getUsuario() + " ja existente!", "Erro no c!"));
		}
	}

	public Usuario buscarUser(String usuario,String senha) {
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
