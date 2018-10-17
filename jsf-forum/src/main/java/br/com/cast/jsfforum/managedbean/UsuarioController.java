package br.com.cast.jsfforum.managedbean;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import br.com.cast.jsfforum.business.UsuarioBusiness;
import br.com.cast.jsfforum.dto.UsuarioDTO;




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
