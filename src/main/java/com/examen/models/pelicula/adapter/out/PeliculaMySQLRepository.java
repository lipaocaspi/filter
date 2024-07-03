package com.examen.models.pelicula.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examen.models.actor.domain.Actor;
import com.examen.models.pelicula.domain.Pelicula;
import com.examen.models.pelicula.infrastructure.PeliculaRepository;

public class PeliculaMySQLRepository implements PeliculaRepository {

    private final String url;
	private final String user;
	private final String password;
	
	public PeliculaMySQLRepository(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public void save(Pelicula pelicula) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO pelicula (coditerno, nombre, duracion, sinopsis) VALUES (?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pelicula.getCodInterno());
                statement.setString(2, pelicula.getNombre());
                statement.setString(3, pelicula.getDuracion());
                statement.setString(4, pelicula.getSinopsis());
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
			String query = "DELETE FROM pelicula WHERE id = ?";
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
    public void update(Pelicula pelicula) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE pelicula SET codinterno = ?, nombre = ?, duracion = ?, sinopsis = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, pelicula.getCodInterno());
                statement.setString(2, pelicula.getNombre());
                statement.setString(3, pelicula.getDuracion());
                statement.setString(4, pelicula.getSinopsis());
                statement.setInt(5, pelicula.getId());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<Pelicula> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM pelicula WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						Pelicula pelicula = new Pelicula (
							resultSet.getInt("id"),
							resultSet.getString("codinterno"),
                            resultSet.getString("nombre"),
                            resultSet.getString("duracion"),
                            resultSet.getString("sinopsis")
						);
						return Optional.of(pelicula);
					}
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
    }

    @Override
    public List<Pelicula> findAll() {
        List<Pelicula> allPelicula = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM pelicula";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Pelicula pelicula = new Pelicula (
							resultSet.getInt("id"),
							resultSet.getString("codinterno"),
                            resultSet.getString("nombre"),
                            resultSet.getString("duracion"),
                            resultSet.getString("sinopsis")
						);
						allPelicula.add(pelicula);
					}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return allPelicula;
    }

}