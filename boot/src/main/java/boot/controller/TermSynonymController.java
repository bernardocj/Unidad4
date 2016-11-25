package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.TermSynonym;
import boot.service.TermSynonymService;


@Controller
public class TermSynonymController {
  
	
		@Autowired
		private TermSynonymService termSynonymService;
		
		
		@GetMapping("/new-term")
		public String newTermSynonym(HttpServletRequest request){
			request.setAttribute("mode", "MODE_NEW_TERM");
			return "termSynonym";
		}
		
		@PostMapping("/save-term")
		public String saveTermSynonym(@ModelAttribute TermSynonym termSynonym, BindingResult bindingResult, HttpServletRequest request){
			termSynonymService.saveTermSynonym(termSynonym);
			request.setAttribute("termSynonyms", termSynonymService.findAll());
			request.setAttribute("mode", "MODE_TERMS");
			return "termSynonym";
		}
		
		
		@GetMapping("/update-term")
		public String updateTermSynonym(@RequestParam int id, HttpServletRequest request){
			request.setAttribute("termSynonym", termSynonymService.findTermSynonym(id));
			request.setAttribute("mode", "MODE_UPDATE_TERM");
			return "termSynonym";
		}
		
		@GetMapping("/delete-term")
		public String deleteTermSynonym(@RequestParam int id, HttpServletRequest request){
			termSynonymService.deleteTermSynonym(id);
			request.setAttribute("termSynonyms", termSynonymService.findAll());
			request.setAttribute("mode", "MODE_TERMS");
			return "termSynonym";
		}
		@GetMapping("/all-terms")
		public String allTerms(HttpServletRequest request){
			request.setAttribute("termSynonyms", termSynonymService.findAll());
			request.setAttribute("mode", "MODE_TERMS");
			return "termSynonym";
		}
		
 }
