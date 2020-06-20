package beans;

import java.io.File;

public class Photo {
private String titre,description;
private double width,height;
private String dateCreation, dateMaj;
private File file;

public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Photo(String titre, String description, double width, double height, String dateCreation, String dateMaj) {
	super();
	this.titre = titre;
	this.description = description;
	this.width = width;
	this.height = height;
	this.dateCreation = dateCreation;
	this.dateMaj = dateMaj;


}
public String getDescription() {
	return description;
}
public File getFile() {
	return file;
}
public void setFile(File file) {
	this.file = file;
}
public void setDescription(String description) {
	this.description = description;
}
public double getWidth() {
	return width;
}
public void setWidth(double width) {
	this.width = width;
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}
public String getDateCreation() {
	return dateCreation;
}
public void setDateCreation(String dateCreation) {
	this.dateCreation = dateCreation;
}
public String getDateMaj() {
	return dateMaj;
}
public void setDateMaj(String dateMaj) { 
	this.dateMaj = dateMaj;
}

}
