package com.examen.models.genero.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examen.models.formato.domain.Formato;
import com.examen.models.genero.domain.Genero;
import com.examen.models.genero.infrastructure.GeneroRepository;

public class GeneroMySQLRepository implements GeneroRepository {

    private final String url;
	private final String user;
	private final String password;
	
	public GeneroMySQLRepository(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public void save(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO genero VALUES (?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, genero.getDescripcion());
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
			String query = "DELETE FROM genero WHERE id = ?";
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
    public void update(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE genero SET descripcion = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, genero.getDescripcion());
				statement.setInt(2, genero.getId());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<Genero> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM genero WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						Genero genero = new Genero (
							resultSet.getInt("id"),
							resultSet.getString("descripcion")
						);
						return Optional.of(genero);
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
    public List<Genero> findAll() {
        // TODO Auto-generated method stub
        List<Genero> allGenero = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM genero";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Genero genero = new Genero (
							resultSet.getInt("id"),
							resultSet.getString("descripcion")
						);
						allGenero.add(genero);
					}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return allGenero;
    }

}