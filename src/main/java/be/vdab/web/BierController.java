package be.vdab.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;

@Controller
@RequestMapping("/bieren")
public class BierController {
	private static final String BESTEL_BIER_VIEW = "bieren/bestel";
	private static final String REDIRECT_BROUWERS_VIEW = "brouwers/brouwers";

	private static final Logger LOGGER= Logger.getLogger(BierController.class.getName());
	@GetMapping("{bier}")
	ModelAndView read(@PathVariable Bier bier) {
		ModelAndView mav = new ModelAndView(BESTEL_BIER_VIEW);
		if (bier != null) {
			mav.addObject(bier);
		}
		return mav;
	}

	@PostMapping("{bier}")
	String storeInSession(@PathVariable Bier bier, @RequestBody long aantal) {
		LOGGER.log(Level.INFO, "bier:{0} -> aantal={1}", new Object[] {bier.getId(), aantal});
		return REDIRECT_BROUWERS_VIEW;
	}

}
