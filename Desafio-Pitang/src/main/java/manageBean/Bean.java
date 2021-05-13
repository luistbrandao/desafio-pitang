package manageBean;

import java.util.List;

import model.loginBean;
import model.Telefone;
import model.Usuario;
import repository.UsuarioRepository;

public class bean {
	
	private Usuario usuario;
	private Telefone telefone;
	private List<Usuario> usuarios;
	
	
	public void cadastrar(Usuario usuario) {
		UsuarioRepository ur = new UsuarioRepository();
		ur.add(usuario);
	}
	
	public void login() {
		UsuarioRepository ur = new UsuarioRepository();
		loginBean bean = new loginBean();
		ur.login(bean);
	}
	
	public void listar() {
		UsuarioRepository ur = new UsuarioRepository();
		ur.listar();
	}
	
	public void atualizar(Usuario usuario) {
		UsuarioRepository ur = new UsuarioRepository();
		ur.atualizar(usuario);
	}
}
