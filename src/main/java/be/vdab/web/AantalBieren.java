package be.vdab.web;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//deze class is nodig voor communicatie tussen front and backend
public class AantalBieren {

	@NotNull
	@Min(1)
	private Integer aantal;

	public Integer getAantal() {
		return aantal;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}

}
