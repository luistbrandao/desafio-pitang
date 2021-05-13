package dao;

import java.sql.DriverManager;
import java.util.List;

import javax.management.Query;
import javax.persistence.TypedQuery;

import model.loginBean;
import model.Usuario;
import persistence.conexao;
import javax.persistence.*;
public class UsuarioRepository {
	
	private conexao banco = conexao.getCurrentInstance();
	
	//Statment stmt = conexao.createStatement(); 
	
	
	
	public List<Usuario> listar() {
		TypedQuery<Usuario> query = banco.conectarEntityManager().createQuery("select u form USUARIO", Usuario.class);
		List<Usuario> userList = query.getResultList();

		return userList;
	}

	public Usuario login(loginBean bean) {
		TypedQuery<Usuario> query = banco.conectarEntityManager().createQuery("select u from USUARIO where USUARIO.email = ?1 and USUARIO.senha = ?2",
				Usuario.class);
		query.setParameter(1, bean.getEmail());
		query.setParameter(2, bean.getSenha());

		if (query.getResultList().isEmpty()) {
			return new Usuario();
		}

		Usuario first = query.getSingleResult();
		return first;
	}

	public void remove(Long id) {
		Usuario u = banco.conectarEntityManager().find(Usuario.class, id);
		if (u != null) {
			banco.conectarEntityManager().remove(u);
		}		
	}
	
	
	//public Class<? extends List> listarTodos() {
	//	javax.persistence.Query query = banco.conectarEntityManager().createNativeQuery("select u from USUARIO", Usuario.class);
	//	return query;
	//}

	public void atualizar(Usuario usuario) {
		Usuario bancoUser = banco.conectarEntityManager().find(Usuario.class, usuario.getId());
		if (bancoUser != null) {
			bancoUser.setEmail(usuario.getEmail());
			bancoUser.setSenha(usuario.getSenha());
			
			for (int i = 0; i <= bancoUser.getTelefones().size(); i++) {
				bancoUser.getTelefones().get(i).setDdd(usuario.getTelefones().get(i).getDdd());
				bancoUser.getTelefones().get(i).setNumero(usuario.getTelefones().get(i).getNumero());
			}
			//usuario = new Usuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), 
			//		usuario.getTelefones());
			add(usuario);
		}
	}
	

	public Usuario add(Usuario usuario) {
		javax.persistence.Query query = banco.conectarEntityManager().createNativeQuery("select u from USUARIO where USUARIO.email = ", Usuario.class);
		query.executeUpdate();
			banco.conectarEntityManager().persist(usuario);
			//banco.conectarTrans().commit();
			TypedQuery<Usuario> q = banco.conectarEntityManager().createQuery("select u from USUARIO where USUARIO.email = ", Usuario.class);
			q.setParameter(1, usuario.getEmail());
			Usuario user = q.getResultList().get(0);
			if(user == null) {
				return null;
			}

			return user;
		
	}

}
