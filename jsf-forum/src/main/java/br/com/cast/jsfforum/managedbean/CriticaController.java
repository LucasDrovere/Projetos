package br.com.cast.jsfforum.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.cast.jsfforum.business.CriticaBusiness;
import br.com.cast.jsfforum.dto.CriticaDTO;

@ManagedBean(name = "critica")
public class CriticaController {
	private CriticaDTO criticaDTO;
	private CriticaBusiness criticaBusiness;

	
	public CriticaController(){
		
	}
	
	@PostConstruct
	public void aposContrucao() {
		this.criticaDTO = new CriticaDTO();
		this.criticaBusiness = new CriticaBusiness();
	}
	
	public void salvar(String usuario, String senha) {
		criticaBusiness.addCritica(criticaDTO, usuario, senha);
	}
	
	public void remover(Integer id) {
		criticaBusiness.remover(id);
	}
}

