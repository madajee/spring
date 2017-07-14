package springtutorial.OffersController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OffersController {
	
	/*@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home"); 
		Map<String, Object> model = mv.getModel();
		model.put("name", "River");
		//session.setAttribute("name", "Boris");
		return mv;	
	}*/
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		model.addAttribute("name", "<b>Tiffany</b>");
		return "home";
	}
	
}
