package br.com.cast.jsfforum.business;

import br.com.cast.jsfforum.dto.CriticaDTO;
import br.com.cast.jsfforum.entidade.Critica;
import br.com.cast.jsfforum.entidade.Usuario;
import br.com.cast.jsfforum.persistencia.CriticaDao;
import br.com.cast.jsfforum.persistencia.UsuarioDao;

public class CriticaBusiness {

	CriticaDao criDao;
	UsuarioDao usuDao;
	
	
	
	public CriticaBusiness(){
		this.criDao = new CriticaDao();
		this.usuDao = new UsuarioDao();
		
	}
	
	
	public void addCritica(CriticaDTO criticaDTO, String usuario, String senha) {
		Usuario user = usuDao.buscarUser(usuario, senha);
		
		Critica c = new Critica();
		c.setDescricao(criticaDTO.getDescricao());
		c.setTitulo(criticaDTO.getTitulo());
		c.setUsuario(user);
		
		criDao.addCritica(c);
		
	}
	
	
	public void remover(Integer id) {
		criDao.remover(id);
	}
	
}
