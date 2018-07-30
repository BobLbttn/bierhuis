package be.vdab.web;


import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.BestelBon;
import be.vdab.entities.Bier;
import be.vdab.valueobjects.BestelbonLijn;
import be.vdab.services.BestelBonService;
import be.vdab.services.BierService;
//import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenController {
	private static final String WINKELWAGEN_VIEW = "winkelwagen/winkelwagen";
	private static final Logger LOGGER= Logger.getLogger(WinkelwagenController.class.getName());
	private final BierService bierService;
	private final Bestelling bestelling;
	private final BestelBonService bestelbonService;
	
	WinkelwagenController(Bestelling bestelling, BierService biersvc, BestelBonService bbsvc) {
		LOGGER.log(Level.INFO, "constructor winkelwagencontroller");
		this.bestelling = bestelling;
		this.bierService = biersvc;
		this.bestelbonService = bbsvc;
	}	
	
	
	//fill session bestellijnen in BestelBon(bestelbonlijnen).
	int FillBestelbonLijnen (BestelBon b) {
		if(bestelling.aantalBestellijnen() > 0) {
			Set<BestelbonLijn> bestelbonlijnen = bestelling.getBestellijnen()
					.entrySet()
					.stream()
					.map(bl -> {
									Optional<Bier> bier = bierService.read(bl.getKey());
									if (bier.isPresent()) {
										return new BestelbonLijn(bier.get(), bl.getValue());
									};
									return null;
							   }
					)
					.collect(Collectors.toSet());
			b.setBestelbonlijnen(bestelbonlijnen);
			return bestelbonlijnen.size();
		}
		return 0;
	}
	
	@GetMapping
	ModelAndView createForm() {
		LOGGER.log(Level.INFO, "create form");
		BestelBon bestelbon = new BestelBon();
		if (FillBestelbonLijnen(bestelbon) > 0) {
			return new ModelAndView(WINKELWAGEN_VIEW).addObject(bestelbon);
		}
		else {
			return new ModelAndView(WINKELWAGEN_VIEW,"fout","Geen bestellingen");
		}
	}

	@PostMapping
	ModelAndView create(@Valid BestelBon bestelbon, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.log(Level.INFO, "binding probleem");
			return new ModelAndView(WINKELWAGEN_VIEW,"fout","binding probleem");
		}
		else  {
			FillBestelbonLijnen(bestelbon);
			bestelbonService.create(bestelbon);
			bestelling.clearBestellijnen();
			LOGGER.log(Level.INFO, "bestelbon:{0}", new Object[] {bestelbon.getId()});
		}
		return new ModelAndView(WINKELWAGEN_VIEW,"id",bestelbon.getId());
	}

	@InitBinder("bestelBon")
	void initBinder(DataBinder binder) {
		binder.initDirectFieldAccess();
	}

}
