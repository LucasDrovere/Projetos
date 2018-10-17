package br.com.cast.jsfforum.managedbean;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cast.jsfforum.business.UsuarioBusiness;
import br.com.cast.jsfforum.entidade.Usuario;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController {
	private UsuarioBusiness userBusiness;
	private String nome;
	private String usuario;
	private String senha;
	private boolean isLogado;

	@PostConstruct
	public void aposConstrucao() {
		this.userBusiness = new UsuarioBusiness();
	}

	public String doLogin() {
		Usuario u = userBusiness.buscarUser(usuario, senha);
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
		if (usuario != null) {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "login";
		}
		return "login";
	}

	public boolean isLogado() {
		return isLogado;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
