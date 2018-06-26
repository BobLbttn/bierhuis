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

@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenController {
	private static final String WINKELWAGEN_VIEW = "winkelwagen/winkelwagen";
	@GetMapping("/")
	ModelAndView createForm() {
		return new ModelAndView(WINKELWAGEN_VIEW);
	}

}
