package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Product;
import boot.model.Task;
import boot.model.TermSynonym;
import boot.model.Travel;
import boot.service.TaskService;
import boot.service.ProductService;
import boot.service.TermSynonymService;
import boot.service.TravelService;

@Controller
public class MainController {
  
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("task")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_TASK");
		return "task";
	}
	
	@GetMapping("product")
	public String product(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_PRODUCT");
		return "product";
	}
	
	@GetMapping("termSynonym")
	public String termSynonym(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_TERM");
		return "termSynonym";
	}
	@GetMapping("travel")
	public String travel(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_TRAVEL");
		return "travel";
	}
	@GetMapping("song")
	public String song(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_SONG");
		return "song";
	}
		
 }
