package br.com.mvc.jdbc;

import br.com.mvc.models.Equipamento;

public class JDBCteste {

	public static void main(String[] args) {
		EquipamentoDAO dao = new EquipamentoDAO();
		Equipamento e = dao.buscaID(14);
		System.out.println(e.getAdquirido());

	}

}
