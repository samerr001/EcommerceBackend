package com.project.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.*;

@Entity
@Table(name="panier" )
public class Panier {
	private User user;
	private Set<Produit> produit;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "panier_produit",
        joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "panier_id", referencedColumnName = "id"))
	public Set<Produit> getProduit() {
		return produit;
	}

	public void setProduit(Set<Produit> produit) {
		this.produit = produit;
	}

	@OneToOne(mappedBy = "panier")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private int id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
