package app.boutique.dto;

 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

 
@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PRODUIT")
	private Long idProduit;
	
	@Column(name="NOM_PRODUIT", nullable=false)
	@NotEmpty
	private String nomProduit;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="PRIX",nullable=false)
	private double prix;
	
	@Transient
	private double prixTotal;
	
	@Column(name="QUANTITE", nullable = false)
	private int quantite;
	
	@Transient
	private int quantitePanier;
	
	@Column(name="IMAGE",nullable=false)
	private String image;
	
	private boolean nouvelle;
	
	private boolean promotion;
	
 
	public Produit() {
		super();
	}

	public Produit(String nomProduit, double prix, int quantite) {
		super();
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.quantite = quantite;
	}
	

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isNouvelle() {
		return nouvelle;
	}

	public void setNouvelle(boolean nouvelle) {
		this.nouvelle = nouvelle;
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public int getQuantitePanier() {
		return quantitePanier;
	}

	public void setQuantitePanier(int quantitePanier) {
		this.quantitePanier = quantitePanier;
	}
	
}
