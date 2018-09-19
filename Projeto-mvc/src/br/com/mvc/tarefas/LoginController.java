package br.com.mvc.tarefas;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.jdbc.UsuarioDAO;
import br.com.mvc.models.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usr, HttpSession session){
		if (new UsuarioDAO().existeUsuario(usr)){
			session.setAttribute("UsrLogado", usr);
			return "menu";
		}
		return "redirect:formulario-login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
	}
}
