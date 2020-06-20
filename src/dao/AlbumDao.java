package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Album;

public class AlbumDao {

	private static final String SELECT_ALL_ALBUM= "SELECT * FROM album";
	private static final String INSERT_ALBUM_PREPARED = "INSERT INTO album VALUES ( 0,?, ?, ?, ?,?)";
	private static final String UPDATE_ALBUM_PREPARED = "UPDATE album SET titre = ?,datecreation = ?, categorie = ? , type= ? , proprietaire=? WHERE idalbum  = ?";
	private static final String DELETE_ALBUM_PREPARED = "DELETE FROM album WHERE idalbum = ?";
	private static final String SELECT_ALBUM_BY_ID_PREPARED = "SELECT * FROM album WHERE idalbum= ?";

	private static final Connection connexion = DAO.getInstance(); 

	public static void createAlbum(Album album) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(INSERT_ALBUM_PREPARED);
			preparedStatement.setString(1, album.getTitre());
			preparedStatement.setString(2, album.getDateCreation());
			preparedStatement.setString(3, album.getCategorie());
			preparedStatement.setString(4, album.getType());
			preparedStatement.setString(5, album.getProprietaire());	
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("l'ajout de l'album a echoué", e);
				}
	}

	public static Album updatealbum(Album album) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(UPDATE_ALBUM_PREPARED);
			preparedStatement.setString(1, album.getTitre());
			preparedStatement.setString(2, album.getDateCreation());
			preparedStatement.setString(3, album.getCategorie());
			preparedStatement.setString(4, album.getType());
			preparedStatement.setString(5, album.getProprietaire());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("mise a jour de l'album a echoué", e);
		}
		return album;
	}

	 
	public static void deletealbum(Album album) {
		PreparedStatement preparedStatement;
		int idalbum = album.getIdalbum();
		try {
			preparedStatement = connexion.prepareStatement(DELETE_ALBUM_PREPARED);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("la supreesion a echoué", e);
		}
	}

	public static List<Album> readalbum() {
		List<Album> albums = null;
		try {

			String titre, datecreation, categorie, type;
			String proprietaire;
			albums = new ArrayList<Album>();
			Statement statement = connexion.createStatement();
			ResultSet reponse = statement.executeQuery(SELECT_ALL_ALBUM);

			while (reponse.next()) {
				titre = reponse.getString("titre");
				datecreation = reponse.getString("datecreation");
				categorie = reponse.getString("categorie");
				type= reponse.getString("type");
			proprietaire=reponse.getString("proprietaire");
				albums.add(new Album(titre, datecreation, categorie, type,proprietaire));
			}

		} catch (SQLException e) {
			throw new DaoException("Une erreur inattendue s'est produite", e);
		}
 		return albums;
	}

	public static Album getalbumById(int idalbum) {
		PreparedStatement preparedStatement;
		List<Album> albums = new ArrayList<Album>();
		try {
			preparedStatement = connexion.prepareStatement(SELECT_ALBUM_BY_ID_PREPARED);
			preparedStatement.setInt(0, idalbum);
			ResultSet resultat = preparedStatement.executeQuery();
			if (resultat.next()) {
				String titre = resultat.getString("titre");
				String datecreation = resultat.getString("datecreation");
				String categorie = resultat.getString("categorie");
				String type = resultat.getString("type");
				String proprietaire= resultat.getString("idutilisteur");			
				albums.add(new Album(titre, datecreation, categorie, type,proprietaire));
			}
		} catch (SQLException e) {
			throw new DaoException("Echec de la suppression", e);
		}
		return null;
	}

}
