package be.vdab.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;

@Controller
@RequestMapping("/bieren")
public class BierController {
	private static final String BESTEL_BIER_VIEW = "bieren/bestel";
	private static final String WINKELWAGEN_VIEW = "redirect:/winkelwagen";
	private static final Logger LOGGER= Logger.getLogger(BierController.class.getName());
	private final Bestelling bestelling;
	
	BierController (Bestelling b){
		this.bestelling = b;
	}
	
	@GetMapping("{bier}")
	ModelAndView read(@PathVariable Bier bier) {
		ModelAndView mav = new ModelAndView(BESTEL_BIER_VIEW);
		if (bier != null) {
			mav.addObject(bier).addObject(new AantalBieren());
		}
		return mav;
	}

	@PostMapping("{bier}")
	ModelAndView storeInSession(@PathVariable Bier bier, @Valid AantalBieren aantalBieren, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.log(Level.INFO, "er ging iets verkeerd");
		}
		else  {
			LOGGER.log(Level.INFO, "bier:{0} -> aantal={1}", new Object[] {bier.getId(), aantalBieren.getAantal()});
			bestelling.setBestellijn(bier.getId(), aantalBieren.getAantal());
		}
		return new ModelAndView(WINKELWAGEN_VIEW);
	}

}
