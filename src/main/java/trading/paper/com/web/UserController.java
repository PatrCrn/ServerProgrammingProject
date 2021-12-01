package trading.paper.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import trading.paper.com.domain.SignupForm;
import trading.paper.com.domain.User;
import trading.paper.com.domain.UserDAO;

import javax.validation.Valid;

@Controller
public class UserController {
	@Autowired
    private UserDAO userDAO;
	
    @RequestMapping(value = "/signup")
    public String addTrader(Model model){
    	model.addAttribute("signupform", new SignupForm());
        return "tradersignup";
    }	
    
    /**
     * Create new user
     * Check if user already exists & form validation
     * 
     * @param signupForm
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
	    		String pwd = signupForm.getPassword();
		    	String hashPwd = new BCryptPasswordEncoder().encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupForm.getUsername());
				newUser.setEmail(signupForm.getMail());
		    	newUser.setRole("USER");
		    	boolean exists = false;
		    	try {
					User user = userDAO.findByUsername(signupForm.getUsername());
					if (user != null) {
						exists = true;
						bindingResult.rejectValue("username", "err.username", "Username already exists");
						return "tradersignup";
					}
				} catch (Exception ignored) {
				} finally {
		    		if (!exists) userDAO.save(newUser);
				}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "tradersignup";
    		}
    	}
    	else {
    		return "tradersignup";
    	}
    	return "redirect:/login";    	
    }
}
