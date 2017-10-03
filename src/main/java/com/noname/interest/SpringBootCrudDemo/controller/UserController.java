package com.noname.interest.SpringBootCrudDemo.controller;

import com.noname.interest.SpringBootCrudDemo.model.User;
import com.noname.interest.SpringBootCrudDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/users")
	public String getUsers(Map<String, Object> model) {
		model.put("users", userRepository.findAll());
		return "users";
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String addUser(@RequestParam String username, @RequestParam String password) {
		User user = new User(username, password);
		userRepository.save(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/users/update/{userId}", method = RequestMethod.GET)
	public String showUpdateUserPage(Map<String, Object> model, @PathVariable("userId") Long userId) {
		model.put("user", userRepository.findOne(userId));
		return "users-update";
	}

	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public String saveUser(@RequestParam Long id, @RequestParam String username, @RequestParam String password) {
		User user = new User(id, username, password);
		userRepository.save(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/users/remove/{userId}", method = RequestMethod.GET)
	public String removeUser(@PathVariable("userId") Long userId) {
		userRepository.delete(userId);
		return "redirect:/users";
	}

}
