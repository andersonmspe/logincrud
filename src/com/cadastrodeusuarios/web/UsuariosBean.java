package com.cadastrodeusuarios.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.cadastrodeusuarios.model.Usuario;
import com.cadastrodeusuarios.service.UsuarioService;


@Named
@SessionScoped
public class UsuariosBean implements Serializable {

	private Usuario usuario = new Usuario();
	
	@EJB
	UsuarioService usuarioService;
	
	public List<Usuario> getUsuarios() {
		return usuarioService.listAll();
	}
	
	public String gravar() {
		usuarioService.createOrUpdate(usuario);
		usuario = new Usuario();
		return "usuarios";
	}
	
	public String excluir(Integer usuarioId) {
		usuarioService.delete(usuarioId);
		usuario = new Usuario();
		return "usuarios";
	}

	public String editar(Usuario u) {
		usuario = u;
		return "usuarios";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	
		
	public String envia() {

        usuario = usuarioService.getUsuario(usuario.getNome(), usuario.getSenha());
        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        } else {
            return "/main";
        }

    }
	
}
