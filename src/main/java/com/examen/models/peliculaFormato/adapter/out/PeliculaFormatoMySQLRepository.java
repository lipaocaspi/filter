package com.examen.models.peliculaFormato.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.examen.models.peliculaFormato.domain.PeliculaFormato;
import com.examen.models.peliculaFormato.infrastructure.PeliculaFormatoRepository;

public class PeliculaFormatoMySQLRepository implements PeliculaFormatoRepository {

    private final String url;
	private final String user;
	private final String password;
	
	public PeliculaFormatoMySQLRepository(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public void save(PeliculaFormato peliculaFormato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO peliculaFormato (idPelicula, idFormato, cantidad) VALUES (?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, peliculaFormato.getIdPelicula());
                statement.setInt(2, peliculaFormato.getIdFormato());
                statement.setInt(3, peliculaFormato.getCantidad());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "DELETE FROM peliculaFormato WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void update(PeliculaFormato peliculaFormato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE peliculaFormato SET idPelicula = ?, idFormato = ?, cantidad = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, peliculaFormato.getIdPelicula());
                statement.setInt(2, peliculaFormato.getIdFormato());
                statement.setInt(3, peliculaFormato.getCantidad());
                statement.setInt(4, peliculaFormato.getIdFormato());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<PeliculaFormato> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PeliculaFormato> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}