package com.examen.models.formato.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examen.models.formato.domain.Formato;
import com.examen.models.formato.infrastructure.FormatoRepository;
import com.examen.models.tipoActor.domain.TipoActor;

public class FormatoMySQLRepository implements FormatoRepository{

    private final String url;
	private final String user;
	private final String password;
	
	public FormatoMySQLRepository(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public void save(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "INSERT INTO formato VALUES (?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, formato.getDescripcion());
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
			String query = "DELETE FROM formato WHERE id = ?";
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
    public void update(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "UPDATE formato SET descripcion = ? WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, formato.getDescripcion());
				statement.setInt(2, formato.getId());
				statement.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<Formato> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM formato WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						Formato formato = new Formato (
							resultSet.getInt("id"),
							resultSet.getString("descripcion")
						);
						return Optional.of(formato);
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
    public List<Formato> findAll() {
        List<Formato> allFormato = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String query = "SELECT * FROM formato";
			try (PreparedStatement statement = connection.prepareStatement(query);
					ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Formato formato = new Formato (
							resultSet.getInt("id"),
							resultSet.getString("descripcion")
						);
						allFormato.add(formato);
					}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return allFormato;
    }

}