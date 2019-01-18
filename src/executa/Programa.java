package executa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import dao.ConnectionFactory;
import dao.ContatoDAO;
import model.Contato;

public class Programa {
	
	public static void verificaConexao(Connection conexao ) throws SQLException {
		if(conexao.isClosed()) {
			System.out.println("desconectado");
		}else {
			System.out.println("conectado");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();
		
		contato.setNome("Fabricio");
		contato.setEmail("fa@gmail.com");
		contato.setEndereco("rua das orquides");
		contato.setDataNascimento(Calendar.getInstance());
		
		//dao.salvar(contato);
		
		Long id = 2L;
		contato.setId(id);
		contato.setNome("rubia");
		//dao.editar(contato);
		
		Long idDelete = 2l;
		contato.setId(idDelete);
		//dao.apagar(contato);
		
		
		List<Contato> lista = dao.busca();
		for (Contato c : lista) {
			System.out.println("nome: " + c.getNome());
			System.out.println("email: " + c.getEmail());
			System.out.println("endereco: " + c.getEndereco());
			System.out.println("data nascimento: " + c.getDataNascimento());
			
		}
	}

	
}


























