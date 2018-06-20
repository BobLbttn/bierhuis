package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name="brouwers")
public class Brouwers implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Length(min = 1, max = 100)
	@SafeHtml
	private String naam;
	@Valid
	private Adres adres;
	private BigDecimal omzet;

	public Brouwers () {}
	
	public Brouwers(long brouwernr, String brnaam, Adres adres, BigDecimal omzet) {
		this.id = brouwernr;
		this.naam = brnaam;
		this.adres = adres;
		this.omzet = omzet;
	}

	public long getBrouwernr() {
		return id;
	}

	public String getBrnaam() {
		return naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public BigDecimal getOmzet() {
		return omzet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
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
		Brouwers other = (Brouwers) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

}
