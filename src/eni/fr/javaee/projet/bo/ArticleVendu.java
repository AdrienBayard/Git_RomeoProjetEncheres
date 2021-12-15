package eni.fr.javaee.projet.bo;


import java.time.LocalDateTime;

public class ArticleVendu {
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	private int categorie;
	private int no_utilisateur;
	private String pseudo;
	private int meilleurEnchere;
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int categorie) {
		
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;  
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		
	}
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix,int prixVente, int no_utilisateur, int categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;  
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.no_utilisateur = no_utilisateur;
		
	}
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, int miseAPrix,int prixVente, int categorie,  int no_utilisateur, String pseudo, int meilleurEnchere) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;  
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.meilleurEnchere = meilleurEnchere;
	}

	
	public int getNoArticle() {
		return noArticle;
	}

	public int getMeilleurEnchere() {
		return meilleurEnchere;
	}
	public void setMeilleurEnchere(int meilleurEnchere) {
		this.meilleurEnchere = meilleurEnchere;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDesciption(String description) {
		this.description = description;
	}

	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	
	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	
	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}




	public int getNo_utilisateur() {
		return no_utilisateur;
	}


	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", categorie=" + categorie + no_utilisateur + "pseudo=" + pseudo + "]";
	}

}
