package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.entities.Bier;

@Embeddable
public class BestelbonLijn implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bierid")
	@NotNull
	private Bier bier;
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	@Min(1)
	private Integer aantal;
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	@Min(0)
	private BigDecimal prijs;
	
	BestelbonLijn () {}

	public BestelbonLijn(Bier bier, Integer aantal) {
		this.bier = bier;
		this.aantal = aantal;
		//geen input voor prijs dus wordt aangenomen prijs = bierprijs
		this.prijs = bier.getPrijs();
	}

	public Bier getBier() {
		return bier;
	}

	public Integer getAantal() {
		return aantal;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
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
		BestelbonLijn other = (BestelbonLijn) obj;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}

	public BigDecimal getTotaalBestelbonLijn(){
		return prijs.multiply(BigDecimal.valueOf(aantal));
	}
	
}
