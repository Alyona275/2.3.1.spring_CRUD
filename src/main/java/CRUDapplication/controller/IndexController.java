package CRUDapplication.controller;

import CRUDapplication.model.Role;
import CRUDapplication.model.User;
import CRUDapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class IndexController {

    private UserService userService;

    @Autowired
    public IndexController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }

@GetMapping("/registration")
public String registrationPage(Model model) {
    model.addAttribute("user", new User());
    return "registration";
}
    @PostMapping(value = "/registration")
    public String registrationUser(@Validated User user,
                                   @RequestParam String roleName, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        Set<Role> role = new HashSet<>();
        role.add(new Role(roleName));
        user.setRoles(role);
        userService.addUser(user);

        return "redirect:/";
    }
}
