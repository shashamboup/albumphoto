package beans;

public class Utilistateur {
 private String nom, prenom , login, password,privilege;
public int getIdUtilisateur() {
	return idUtilisateur;
}

public void setIdUtilisateur(int idUtilisateur) {
	this.idUtilisateur = idUtilisateur;
}

private int idUtilisateur;
public String getNom() {
	return nom;
}

public Utilistateur( String nom, String prenom, String login, String password, String privilege) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.login = login;
	this.password = password;
	this.privilege = privilege;
}

public void setNom(String nom) {
	this.nom = nom;
}


public String getPrivilege() {
	return privilege;
}

public void setPrivilege(String privilege) {
	this.privilege = privilege;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
 
}
