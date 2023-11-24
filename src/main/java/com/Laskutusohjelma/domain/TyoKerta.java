package com.Laskutusohjelma.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TyoKerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int tuntimaara;
	private String paivamaara;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tyo_id")
	private Tyo tyo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTuntimaara() {
		return tuntimaara;
	}

	public void setTuntimaara(int tuntimaara) {
		this.tuntimaara = tuntimaara;
	}

	public String getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(String paivamaara) {
		this.paivamaara = paivamaara;
	}

	public Tyo getTyo() {
		return tyo;
	}

	public void setTyo(Tyo tyo) {
		this.tyo = tyo;
	}
	
	

}
