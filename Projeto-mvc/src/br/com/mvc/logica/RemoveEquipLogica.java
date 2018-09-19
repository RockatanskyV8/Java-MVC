package br.com.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mvc.jdbc.EquipamentoDAO;
import br.com.mvc.models.Equipamento;

public class RemoveEquipLogica implements Logica{
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Equipamento eq = new Equipamento();
		eq.setId(id);
		
		Connection con = (Connection) req.getAttribute("conexao");
		
		EquipamentoDAO dao = new EquipamentoDAO(con);
		dao.Remove(eq);
		
		System.out.println("Excluindo equipamento...");
		
		return "mvc?logica=ListaEquipLogica";
	}

}
