package springtutorial.OffersController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("name", "<b>Tiffany</b>");
		return "home";
		
	}

}
