package com.examen.models.tipoActor.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examen.models.pais.domain.Pais;
import com.examen.models.tipoActor.domain.TipoActor;
import com.examen.models.tipoActor.infrastructure.TipoActorRepository;

public class TipoActorMySQLRepository implements TipoActorRepository {

    private final String url;
	private final String user;
	private final String password;
	
	public TipoActorMySQLRepository(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public void save(TipoActor tipoActor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO tipoactor VALUES (?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, tipoActor.getDescripcion());
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
			String query = "DELETE FROM tipoactor WHERE id = ?";
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
    public void update(TipoActor tipoActor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE tipoactor SET descripcion = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, tipoActor.getDescripcion());
				statement.setInt(2, tipoActor.getId());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<TipoActor> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM tipoactor WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						TipoActor tipoActor = new TipoActor (
							resultSet.getInt("id"),
							resultSet.getString("descripcion")
						);
						return Optional.of(tipoActor);
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
    public List<TipoActor> findAll() {
        List<TipoActor> allTipoActor = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM tipoactor";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						TipoActor tipoActor = new TipoActor (
							resultSet.getInt("id"),
							resultSet.getString("descripcion")
						);
						allTipoActor.add(tipoActor);
					}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return allTipoActor;
    }

}