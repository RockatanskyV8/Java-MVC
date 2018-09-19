package br.com.mvc.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



public class Equipamento {
	  private int id;
	  
	  @Size(min=5, message="O nome deve ter pelo menos 5 letras")
	  private String name;
	  private String local;
	  
	  @DateTimeFormat(pattern="dd/MM/yyyy")
	  private Calendar adquirido;
	
	  public void setId(int id){
	    this.id = id;
	  }
	
	  public void setName(String n){
	    this.name = n;
	  }
	  public void setLocal(String l){
	    this.local = l;
	  }
	  /*
	  public void setAdquirido(Calendar adquirido2){
		    this.adquirido = adquirido2;
	  }
	  */
	  public void setAdquirido(String adquirido){
		  Calendar data = null;
		  try{
				Date d = new SimpleDateFormat("dd/MM/yyyy").parse(adquirido);
				data = Calendar.getInstance();
				data.setTime(d);
				this.adquirido = data;
			}catch(ParseException e){
				 System.out.println("Erro de conversão da data");
	             return;
			}
	  }
	
	  public int getId(){
	    return this.id;
	  }
	  public String getName(){
	    return this.name;
	  }
	  public String getLocal(){
	    return this.local;
	  }
	  public Calendar getAdquirido(){
		    return this.adquirido;
	  }
}
