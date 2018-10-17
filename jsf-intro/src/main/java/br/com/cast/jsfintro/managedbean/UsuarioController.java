package br.com.cast.jsfintro.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.jsfintro.business.UsuarioBusiness;
import br.com.cast.jsfintro.dto.UsuarioDTO;

@ManagedBean
public class UsuarioController {
	private UsuarioDTO usuarioDTO;
	private UsuarioBusiness usuarioBusiness;

	public UsuarioController() {

	}

	@PostConstruct
	public void aposConstrucao() {
		this.usuarioDTO = new UsuarioDTO();
		this.usuarioBusiness = new UsuarioBusiness();
	}

	public void salvar() {
		usuarioBusiness.salvar(usuarioDTO);
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}
}
