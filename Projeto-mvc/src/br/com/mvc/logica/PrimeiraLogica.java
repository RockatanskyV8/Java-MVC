package br.com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executados a logica...");
		System.out.println("Retornando o nome da pagina JSP...");
		return "WEB-INF/jsp/primeira-logica.jsp";
	}

}
