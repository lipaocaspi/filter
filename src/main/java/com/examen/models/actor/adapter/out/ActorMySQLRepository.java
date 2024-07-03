package com.examen.models.actor.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examen.models.actor.domain.Actor;
import com.examen.models.actor.infrastructure.ActorRepository;
import com.examen.models.tipoActor.domain.TipoActor;

public class ActorMySQLRepository implements ActorRepository {

    private final String url;
	private final String user;
	private final String password;
	
	public ActorMySQLRepository(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public void save(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO actor (nombre, idNacionalidad, edad, genero) VALUES (?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdNacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getGenero());
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
			String query = "DELETE FROM actor WHERE id = ?";
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
    public void update(Actor actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE actor SET nombre = ?, idNacionalidad = ?, edad = ?, genero = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, actor.getNombre());
                statement.setInt(2, actor.getIdNacionalidad());
                statement.setInt(3, actor.getEdad());
                statement.setInt(4, actor.getGenero());
				statement.setInt(5, actor.getId());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<Actor> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM actor WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						Actor actor = new Actor (
							resultSet.getInt("id"),
							resultSet.getString("nombre"),
                            resultSet.getInt("idNacionalidad"),
                            resultSet.getInt("edad"),
                            resultSet.getInt("genero")
						);
						return Optional.of(actor);
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
    public List<Actor> findAll() {
        List<Actor> allActor = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM actor";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Actor actor = new Actor (
							resultSet.getInt("id"),
							resultSet.getString("nombre"),
                            resultSet.getInt("idNacionalidad"),
                            resultSet.getInt("edad"),
                            resultSet.getInt("genero")
						);
						allActor.add(actor);
					}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return allActor;
    }

}