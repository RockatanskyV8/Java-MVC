package br.com.mvc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mvc.models.Equipamento;

@Repository
public class EquipamentoDAO {
	private Connection con;
	
	
	@Autowired
    public EquipamentoDAO(DataSource dataSource) {
        try{
        	this.con = dataSource.getConnection();
        }catch(SQLException e){
        	throw new RuntimeException(e);
        }
    }
	
    public EquipamentoDAO(Connection connection) {
        this.con = connection;
    }
	
    public EquipamentoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
	
    public void adiciona(Equipamento e){
		String sql = "insert into equipamento (nome,local,adquirido) values (?,?,?)";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			String nome 		= e.getName();
			String local 		= e.getLocal();
			Calendar adquirido	= Calendar.getInstance();
			adquirido.setTime(e.getAdquirido().getTime());
			
			stmt.setString(1, nome);
			stmt.setString(2, local);
			stmt.setDate(3, new java.sql.Date( adquirido.getTimeInMillis() ) );
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Gravado!");
			
			con.close();
			
		}catch(SQLException erroSQL){
			throw new RuntimeException(erroSQL);
		}
    }

	public void Altera(Equipamento e){
		String sql = "UPDATE equipamento SET " +
		"nome=?, local=?, adquirido=? WHERE equip_id=?";
		
		try{
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			int id		   		= e.getId();
			String nome 		= e.getName();
			String local 		= e.getLocal();
			Calendar adquirido	= Calendar.getInstance();
			adquirido.setTime(e.getAdquirido().getTime());
			
			
			stmt.setString(1, nome);
			stmt.setString(2, local);
			stmt.setDate(3, new java.sql.Date( adquirido.getTimeInMillis() ));
			stmt.setInt(4, id);
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException erroSQL){
			throw new RuntimeException(erroSQL);
		}
	}
	
	public void Remove(Equipamento c){
		String sql = "DELETE FROM equipamento WHERE equip_id = ?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, c.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
    
	public List<Equipamento> Show()
	{
		String sql = "select * from equipamento";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Equipamento> equipamentos = new ArrayList<Equipamento>();
			
			
			while(rs.next())
			{
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				
				String id   		= rs.getString("equip_id");
				String nome 		= rs.getString("nome");
				String local 		= rs.getString("local");
				cal.setTime(rs.getDate("adquirido"));
				String data = s.format(cal.getTime());
				
				Equipamento e 		= new Equipamento();
				
				e.setId(Integer.parseInt(id));
				e.setName(nome);
				e.setLocal(local);
				e.setAdquirido(data);
				
				equipamentos.add(e);
			}
			
			stmt.close();
			
			
			return equipamentos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public Equipamento buscaID(int id){
		String sql = "select * from equipamento where equip_id = ?";

		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Equipamento eq = new Equipamento();
			
			
			if(rs.next())
			{
				String nome 		= rs.getString("nome");
				String local 		= rs.getString("local");
				cal.setTime(rs.getDate("adquirido"));
				String data = s.format(cal.getTime());
				
				eq.setId(id);
				eq.setName(nome);
				eq.setLocal(local);
				eq.setAdquirido(data);;
			}
			
			stmt.close();
			con.close();
			
			return eq;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
		
}
