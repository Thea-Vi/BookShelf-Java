package com.villanueva.login.registration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.villanueva.login.registration.models.LoginUser;
import com.villanueva.login.registration.models.User;
import com.villanueva.login.registration.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return "redirect:/";
		}

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "log&reg.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session,
			Model model) {

		userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());

			return "log&reg.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";

	}

	@PostMapping("/login")
	public String register(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
			HttpSession session, Model model) {

		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());

			return "log&reg.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";

	}

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long loggedInUserId = (Long) session.getAttribute("user_id");
		session.getAttribute("user_id");

		User loggedInUser = this.userService.findUser(loggedInUserId);

		model.addAttribute("loggedInUser", loggedInUser);

		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		} else {

			return "dashboard.jsp";

		}
	}
}
