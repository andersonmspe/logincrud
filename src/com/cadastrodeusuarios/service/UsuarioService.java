package com.cadastrodeusuarios.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cadastrodeusuarios.model.Usuario;


@Stateless
public class UsuarioService implements Serializable{
	
	@PersistenceContext
	private EntityManager em;
	
	public void createOrUpdate(Usuario usuario) {
		if(usuario.getId() == null) {
			em.persist(usuario);
		}
		else {
			em.merge(usuario);
		}
	}
	
	public void delete(Integer usuarioId) {
		Usuario usuario = findById(usuarioId);
		em.remove(usuario);
		
	}

	public Usuario findById(Integer usuarioId) {
		return em.find(Usuario.class, usuarioId);
	}
	
	
	public List<Usuario> listAll(){
		TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u ORDER BY u.nome", Usuario.class);
		return q.getResultList();
	}
	
	
	public Usuario getUsuario(String nome, String senha) {
		try {
            Usuario usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u where u.nome = :name and u.senha = :password")
                    .setParameter("name", nome)
                    .setParameter("password", senha).getSingleResult();

            return usuario;
	}
	catch (NoResultException e) {
        return null;
    }
	
	}
	
	

}
