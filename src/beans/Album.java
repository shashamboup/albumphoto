package beans;

public class Album {
int idalbum;
private String titre , dateCreation, categorie,type;
public int getIdalbum() {
	return idalbum;
}
public void setIdalbum(int idalbum) {
	this.idalbum = idalbum;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDateCreation() {
	return dateCreation;
}
public void setDateCreation(String dateCreation) {
	this.dateCreation = dateCreation;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public Album(String titre, String dateCreation, String categorie, String type, String proprietaire) {
	super();
	this.titre = titre;
	this.dateCreation = dateCreation;
	this.categorie = categorie;
	this.type = type;
	this.proprietaire = proprietaire;
}
public String getType() {
	return type;
}
public void setType(String type) {
	
	this.type = type;
}
public String getProprietaire() {
	return proprietaire;
}
public void setProprietaire(String proprietaire) {
	this.proprietaire = proprietaire;
}
private String proprietaire;
}