package br.com.servico.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.servico.dao.LoginDAO;
import br.com.servico.modelo.Usuario;
@Path("/logar")
public class LoginRest {

	private LoginDAO dao = new LoginDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{email}/{senha}")
	public Usuario logar(@PathParam("email")String email,@PathParam("senha") String senha){	
		Usuario u = new LoginDAO().validarLogin(email,senha);
		return u;
	}
	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/teste")
	public String teste(){
		return "teste"; 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarTodos")
	public List<Usuario> listarUsuario(){
		return dao.getUsuario();
	}
	*/
}
