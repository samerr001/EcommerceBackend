package com.project.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table

public class Produit {
	private String nompdt;
	private String typepdt;
	private String couleurpdt;
	private String referencepdt;
	private float prixpdt;
	private int quantitepdt;
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	private int id;
	private String img;
	private Set<Panier> panier;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
    
	@ManyToMany(mappedBy = "produit")
	public Set<Panier> getPanier() {
		return panier;
	}
	public void setPanier(Set<Panier> panier) {
		this.panier = panier;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNompdt() {
		return nompdt;
	}
	public void setNompdt(String nompdt) {
		this.nompdt = nompdt;
	}
	public String getTypepdt() {
		return typepdt;
	}
	public void setTypepdt(String typepdt) {
		this.typepdt = typepdt;
	}
	public String getCouleurpdt() {
		return couleurpdt;
	}
	public void setCouleurpdt(String couleurpdt) {
		this.couleurpdt = couleurpdt;
	}
	public String getReferencepdt() {
		return referencepdt;
	}
	public void setReferencepdt(String referencepdt) {
		this.referencepdt = referencepdt;
	}
	public float getPrixpdt() {
		return prixpdt;
	}
	public void setPrixpdt(float prixpdt) {
		this.prixpdt = prixpdt;
	}
	public int getQuantitepdt() {
		return quantitepdt;
	}
	public void setQuantitepdt(int quantitepdt) {
		this.quantitepdt = quantitepdt;
	}

}
