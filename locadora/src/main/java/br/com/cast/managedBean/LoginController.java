package br.com.cast.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cast.business.UsuarioBusiness;
import br.com.cast.dto.UsuarioDTO;
import br.com.cast.entidade.Usuario;

@ManagedBean(name= "login")
public class LoginController {

	private UsuarioBusiness usuarioBusiness;
	private UsuarioDTO usuarioDto;
	private boolean isLogado;
	private String usuario;
	private String senha;
	
	public LoginController() {
		
	}
	
	@PostConstruct
	public void aposConstrucao() {
		this.usuarioBusiness = new UsuarioBusiness();
		this.usuarioDto = new UsuarioDTO();
		
	}

	public String doLogin() {
		Usuario u = usuarioBusiness.buscarUser(usuario, senha);
		
		if (u != null) {
			if (usuario.equals(u.getUsuario()) && senha.equals(u.getSenha())) {
				HttpSession hs = UsuarioBusiness.getSession();
				hs.setAttribute("usuario", usuario);
				isLogado = true;
				return "index";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário "+ usuario + " ou senha incorreto!", "Erro no Login!"));
			isLogado = false;
			return "login";
		}
		return "login";
	}
	
	
	public String doLogout() {
		if (usuarioDto.getUsuario() != null) {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "login";
		}
		return "login";
	}
	
	
	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public UsuarioDTO getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDTO usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
