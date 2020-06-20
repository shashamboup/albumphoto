package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Utilistateur;

public class AdministrateurDao {
	private static final String SELECT_ALL_UTILISATEUR = "SELECT * FROM utilisateur";
	private static final String INSERT_UTILISATEUR_PREPARED = "INSERT INTO utilisateur VALUES ( 0,?, ?, ?, ?,?)";
	private static final String UPDATE_UTILISATEUR_PREPARED = "UPDATE utilisateur SET nom = ?, prenom = ?, login = ? , password = ? , privilege=? WHERE id  = ?";
	private static final String DELETE_UTILISATEUR_PREPARED = "DELETE FROM utilisateur WHERE id = ?";
	private static final String SELECT_UTILISATEUR_BY_SESSION = "SELECT * FROM utilisateur WHERE login = ? AND password = ?";


	private static final Connection connexion = DAO.getInstance(); 

	public static void createUtilistateur(Utilistateur utilisateur) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(INSERT_UTILISATEUR_PREPARED);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setString(5, utilisateur.getPrivilege());
			if(preparedStatement.executeUpdate()==0)
				System.out.println("waouh succes");
			else { 
				System.out.println("rien inserre");
			}
				
		} catch (SQLException e) {
			throw new DaoException("l'ajout de l'utilisateur a echoué", e);
				}

	}

	public static Utilistateur updateUtilisateur(Utilistateur utilisateur) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(UPDATE_UTILISATEUR_PREPARED);
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setString(5, utilisateur.getPrivilege());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("mise a jour de l'utilisateur a echoué", e);
		}
		return utilisateur;
	}

	public static void deleteUtilisateur(Utilistateur utilisateur) {
		PreparedStatement preparedStatement;
		int id = utilisateur.getIdUtilisateur();
		try {
			preparedStatement = connexion.prepareStatement(DELETE_UTILISATEUR_PREPARED);
			preparedStatement.setInt(0, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("la supreesion a echoué", e);
		}
	}

	public static List<Utilistateur> readutilisateur() { 				
		List<Utilistateur> utilisateurs = null;
		try {

			String nom, prenom, login, password,privilege;
			utilisateurs = new ArrayList<Utilistateur>();
			Statement statement = connexion.createStatement();
			ResultSet reponse = statement.executeQuery(SELECT_ALL_UTILISATEUR);

			while (reponse.next()) {
				nom = reponse.getString("nom");
				prenom = reponse.getString("prenom");
				login = reponse.getString("login");
				password = reponse.getString("password");
				privilege=reponse.getString("privilege");
				utilisateurs.add(new Utilistateur(nom, prenom, login, password,privilege));
			}

		} catch (SQLException e) {
			throw new DaoException("Une erreur inattendue s'est produite", e);
		}
 		return utilisateurs;
	}

	public static Utilistateur getUtilisateurBySession(String login,String password) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connexion.prepareStatement(SELECT_UTILISATEUR_BY_SESSION);
			preparedStatement.setString(1,login);
			preparedStatement.setString(2,password);
			ResultSet resultat = preparedStatement.executeQuery();
			if (resultat.next()) {
				
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String privilege = resultat.getString("privilege");
				
				Utilistateur utilisateur =new Utilistateur(nom, prenom, login, password,privilege);
				return utilisateur;
			}
		} catch (SQLException e) {
			throw new DaoException("Echec de la suppression", e);
		}
		return null;
	}
}
