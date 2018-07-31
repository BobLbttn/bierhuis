package be.vdab.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

@Entity
@Table(name="bestelbonnen")
public class BestelBon implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Length(min = 1, max = 50)
	@SafeHtml
	private String naam;
	@Valid
	@Embedded
	@NotNull
	private Adres adres;
	
	@ElementCollection
	@CollectionTable(name = "bestelbonlijnen", joinColumns=@JoinColumn(name = "bestelbonid"))
	Set<BestelbonLijn> bestelbonlijnen;
	
	
	
	public BestelBon() {
		bestelbonlijnen = new LinkedHashSet <>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Set<BestelbonLijn> getBestelbonlijnen() {
		return bestelbonlijnen;
	}

	public void setBestelbonlijnen(Set<BestelbonLijn> bestelbonlijnen) {
		this.bestelbonlijnen = bestelbonlijnen;
	}

	public int aantalBestelbonlijnen()
	{
		return bestelbonlijnen.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BestelBon other = (BestelBon) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
