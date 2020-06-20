package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Photo;


public class PhotoDao {
	private static final String SELECT_ALL_PHOTO= "SELECT idalbum  FROM photo GROUP BY idalbum";
	private static final String INSERT_PHOTO_PREPARED = "INSERT INTO photo VALUES ( 0,?, ?, ?, ?,?,?,?)";
	private static final String UPDATE_PHOTO_PREPARED = "UPDATE photo SET titre = ?,datecreation = ?, categorie = ? , type= ? , idutilisateur=? WHERE idphoto  = ?";
	private static final String DELETE_PHOTO_PREPARED = "DELETE FROM photo WHERE idphoto = ?";
	private static final String SELECT_PHOTO_BY_ID_PREPARED = "SELECT * FROM photo WHERE idphoto= ?";

	private static final Connection connexion = DAO.getInstance(); 

	public static void createphoto(Photo photo) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(INSERT_PHOTO_PREPARED);
			preparedStatement.setString(1, photo.getTitre());
			preparedStatement.setString(2, photo.getDescription());
			preparedStatement.setDouble(3, photo.getWidth());
			preparedStatement.setDouble(4, photo.getHeight());
			preparedStatement.setString(5, photo.getDateCreation());
			preparedStatement.setString(5, photo.getDateMaj());
			if(preparedStatement.executeUpdate()==0)
				System.out.println("waouh succes");
			else {
				System.out.println("rien inserre");
			}
				
			
		} catch (SQLException e) {
			throw new DaoException("l'ajout de l'photo a echoué", e);
				}

	}

	public static Photo updatephoto(Photo photo) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(UPDATE_PHOTO_PREPARED);
			preparedStatement.setString(1, photo.getTitre());
			preparedStatement.setString(2, photo.getDescription());
			preparedStatement.setDouble(3, photo.getWidth());
			preparedStatement.setDouble(4, photo.getHeight());
			preparedStatement.setString(5, photo.getDateCreation());
			preparedStatement.setString(5, photo.getDateMaj());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("mise a jour de l'photo a echoué", e);
		}
		return photo;
	}

	 
	public static void deletephoto(Photo photo) {
		PreparedStatement preparedStatement;
		//int idphoto = photo.getCodePhoto();
		try {
			preparedStatement = connexion.prepareStatement(DELETE_PHOTO_PREPARED);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("la supreesion a echoué", e);
		}
	}

	public static List<Photo> readphoto() {
		List<Photo> photos = null;
		try {

			String titre, datecreation, description, datemaj;
			double width , higth;
			int idutilisateur;
			photos = new ArrayList<Photo>();
			Statement statement = connexion.createStatement();
			ResultSet reponse = statement.executeQuery(SELECT_ALL_PHOTO);

			while (reponse.next()) {
				titre = reponse.getString("titre");
				description= reponse.getString("datecreation");
				width= reponse.getDouble("datecreation");
				higth = reponse.getDouble("categorie");
				datecreation=reponse.getString("idutilisateur");
				datemaj= reponse.getString("datemaj");
				
				photos.add(new Photo(titre,description,width,higth,datecreation,datemaj));
			}

		} catch (SQLException e) {
			throw new DaoException("Une erreur inattendue s'est produite", e);
		}
 		return photos;
	}

	public static Photo getphotoById(int idphoto) {
		PreparedStatement preparedStatement;
		List<Photo> photos = new ArrayList<Photo>();
		try {
			preparedStatement = connexion.prepareStatement(SELECT_PHOTO_BY_ID_PREPARED);
			preparedStatement.setInt(0, idphoto);
			ResultSet resultat = preparedStatement.executeQuery();
			if (resultat.next()) {
				String titre = resultat.getString("titre");
				String description= resultat.getString("datecreation");
				Double width= resultat.getDouble("datecreation");
				Double higth = resultat.getDouble("categorie");
				String datecreation=resultat.getString("idutilisateur");
				String datemaj= resultat.getString("datemaj");		
				photos.add(new Photo(titre,description,width,higth,datecreation,datemaj));
			}
		} catch (SQLException e) {
			throw new DaoException("Echec de la suppression", e);
		}
		return null;
	}


}
