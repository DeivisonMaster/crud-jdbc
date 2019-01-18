package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Contato;

public class ContatoDAO {
	private Connection conexao;
	
	public ContatoDAO() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	
	public void salvar(Contato contato) throws SQLException {
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement statement = this.conexao.prepareStatement(sql);
			
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
		
	}
	
	public void editar(Contato contato) throws SQLException {
		String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";
		
		try {
			
			PreparedStatement statement = this.conexao.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getEmail());
			statement.setString(3, contato.getEndereco());
			statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			statement.setLong(5, contato.getId());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
	}
	
	public void apagar(Contato contato) throws SQLException {
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		try {
			PreparedStatement statement = this.conexao.prepareStatement(sql);
			statement.setLong(1, contato.getId());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
		
	}
	
	public List<Contato> busca() throws SQLException {
		String sql = "SELECT * FROM contatos";
		List<Contato> contatos = new ArrayList<>();
		
		try {
			PreparedStatement statement = this.conexao.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Contato contato = new Contato();
				
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.close();
		}
		return contatos;
		
	}
}



















