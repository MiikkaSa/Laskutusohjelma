package com.Laskutusohjelma.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Tyo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long tyoId;
	private String tyonNimi;
	private int tyonKesto;
	private double tuntipalkka;
	private String paivamaara;
	private double paivapalkka;
	
	@OneToMany(mappedBy = "tyo")
	private List<TyoKerta> tyokerrat;
			
	public Tyo () {}
	
	public Tyo (String tyonNimi, int tyonKesto, double tuntipalkka, String paivamaara, double paivapalkka) {
		super();
		this.tyonNimi=tyonNimi;
		this.tyonKesto=tyonKesto;
		this.tuntipalkka=tuntipalkka;
		this.paivamaara=paivamaara;
		this.paivapalkka=paivapalkka;
	}
	
	public String getTyonNimi() {
		return tyonNimi;
	}

	public void setTyonNimi(String tyonNimi) {
		this.tyonNimi = tyonNimi;
	}
	public long getId() {
		return tyoId;
	}

	public void setId(long tyoId) {
		this.tyoId = tyoId;
	}

	public int getTyonKesto() {
		return tyonKesto;
	}

	public void setTyonKesto(int tyonKesto) {
		this.tyonKesto = tyonKesto;
	}

	public double getTuntipalkka() {
		return tuntipalkka;
	}

	public void setTuntipalkka(double tuntipalkka) {
		this.tuntipalkka = tuntipalkka;
	}

	public String getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(String paivamaara) {
		this.paivamaara = paivamaara;
	}

	public double getPaivapalkka() {
		return paivapalkka;
	}

	public void setPaivapalkka(double paivapalkka) {
		this.paivapalkka = Math.round(paivapalkka * 100.0) / 100.0;
	}

	@Override
	public String toString() {
		return "Tyo [id=" + tyoId + ", tyonNimi=" + tyonNimi + ", tyonKesto=" + tyonKesto + ", palkka=" + tuntipalkka
				+ ", paivamaara=" + paivamaara + ", paivapalkka=" + paivapalkka + "]";
	}


	
	

}
