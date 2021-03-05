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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", userService.getRoles());
        return "registration";
    }
    @PostMapping(value = "/registration")
    public String registrationUser(@Validated User user,
            @RequestParam long roleId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        Role role = userService.getRoleById(roleId);
        user.addRole(role);
        userService.addUser(user);

        return "redirect:/";
    }
}
