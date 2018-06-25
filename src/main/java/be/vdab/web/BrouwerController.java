package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;



@Controller
@RequestMapping("/brouwers")
public class BrouwerController {

	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BIERENBYBROUWERS_VIEW = "brouwers/bieren";

	private final BrouwerService brouwerService;

	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}

	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	
	@GetMapping("{brouwer}")
	ModelAndView read(@PathVariable Brouwer brouwer) {
		ModelAndView mav = new ModelAndView(BIERENBYBROUWERS_VIEW);
		if (brouwer != null) {
			mav.addObject(brouwer);
		}
		return mav;
	}
}
