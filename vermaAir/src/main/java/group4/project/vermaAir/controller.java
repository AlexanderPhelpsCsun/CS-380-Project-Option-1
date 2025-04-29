package group4.project.vermaAir;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

	@GetMapping("/")
	public String home() {
	    return "welcome";
	}S

}
