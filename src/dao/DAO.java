package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static final String	DB_URL		= "jdbc:mysql://localhost/db_album";
	private static final String	DB_USER		= "root";
	private static final String	DB_PASSWORD	= "";
	private static Connection	connexion	= null;

	private DAO()
	{
	}

	public static Connection getInstance() throws DaoException
	{
		if (connexion == null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				connexion = DriverManager.getConnection(DB_URL, DB_USER,
						DB_PASSWORD);
			}
			catch (ClassNotFoundException e)
			{
				throw new DaoException("Erreur de chargement du pilote", e);
			}
			catch (SQLException e)
			{
				throw new DaoException(
						"Erreur de connexion � la base de donn�es", e);
			}
		}
		return connexion;
	}

}

