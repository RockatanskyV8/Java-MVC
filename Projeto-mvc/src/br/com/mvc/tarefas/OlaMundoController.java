package br.com.mvc.tarefas;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.jdbc.EquipamentoDAO;
import br.com.mvc.models.Equipamento;

@Controller
public class OlaMundoController {
	
	EquipamentoDAO dao = new EquipamentoDAO();
	
	@RequestMapping("/olaMundoSpring")
	public String execute(){
		System.out.println("Executando a lógica com Spring MVC");
		return "ok";
	}
	
	@RequestMapping("/listaEquipamentos")
	public String lista(Model model){
		//System.out.println("Executando a lógica com Spring MVC");
		model.addAttribute("equipamentos", dao.Show());
		return "tarefa/listaEquipamento";
	}
	
	@RequestMapping("/novoEquipamento")
	public String form(){
		return "tarefa/adicionarEquipamento";
	}
	
	@RequestMapping("/adicionaEquipamento")
	public String adicionaEquipamento(@Valid Equipamento eq, BindingResult result){
		if(result.hasFieldErrors("name")){
			return "tarefa/adicionarEquipamento";
		}
		
		EquipamentoDAO dao = new EquipamentoDAO();
		dao.adiciona(eq);
		
		return "redirect:listaEquipamentos";
		
	}
	
	@RequestMapping("/removeEquipamento")
	public String removeEquipamento(Equipamento eq){
		
		EquipamentoDAO dao = new EquipamentoDAO();
		dao.Remove(eq);
		
		return "redirect:listaEquipamentos";
		
	}
	
	@RequestMapping("/mostraEquipamento")
	public String alterarEquipamento(int id, Model model){
		EquipamentoDAO dao = new EquipamentoDAO();
		model.addAttribute("equipamento", dao.buscaID(id));
		return "tarefa/alteraEquipamentos";
		
	}
	
	@RequestMapping("/alterarEquipamento")
	public String alteraEquipamento(Equipamento eq){
		EquipamentoDAO dao = new EquipamentoDAO();
		dao.Altera(eq);
		return "redirect:listaEquipamentos";
	}
	
	@RequestMapping("/testetag")
	public String testetag(){
		return "teste";
	}
}

/*
EquipamentoDAO dao = new EquipamentoDAO();
dao.adiciona(eq);
System.out.println("Executando a lógica com Spring MVC");
return "tarefa/listaEquipamento"; 
*/