package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import boot.model.Travel;
import boot.service.TravelService;

@Controller
public class TravelController {
  
		@Autowired
		private TravelService travelService;
		
		@GetMapping("/all-travels")
		public String allTravels(HttpServletRequest request){
			request.setAttribute("travels", travelService.findAll());
			request.setAttribute("mode", "MODE_TRAVELS");
			return "travel";
		}
		
		@GetMapping("/new-travel")
		public String newTravel(HttpServletRequest request){
			request.setAttribute("mode", "MODE_NEW_TRAVEL");
			return "travel";
		}
		
		@PostMapping("/save-travel")
		public String saveTravel(@ModelAttribute Travel travel, BindingResult bindingResult, HttpServletRequest request){
			travelService.saveTravel(travel);
			request.setAttribute("travels", travelService.findAll());
			request.setAttribute("mode", "MODE_TRAVELS");
			return "travel";
		}
		
		@GetMapping("/update-travel")
		public String updateTravel(@RequestParam int id, HttpServletRequest request){
			request.setAttribute("travel", travelService.findTravel(id));
			request.setAttribute("mode", "MODE_UPDATE_TRAVEL");
			return "travel";
		}
		
		@GetMapping("/delete-travel")
		public String deleteTravel(@RequestParam int id, HttpServletRequest request){
			travelService.deleteTravel(id);
			request.setAttribute("travels", travelService.findAll());
			request.setAttribute("mode", "MODE_TRAVELS");
			return "travel";
		}
		
		
 }
