package fa.training.controller;


import fa.training.dto.UserForCreate;
import fa.training.entity.EipCompany;
import fa.training.entity.EipPosition;
import fa.training.service.CompanyService;
import fa.training.service.PositionService;
import fa.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("")
    public String home(Model model){
        List<Object[]> list = userService.list();
        model.addAttribute("users",list);

        UserForCreate user = new UserForCreate();
        model.addAttribute("user", user);

        return "basic-page";
    }
    @PostMapping("")
    public String addUser(@ModelAttribute("user") UserForCreate userForCreate) {

        userService.addUserWithPosts(userForCreate);

        return "redirect:/home"; // Redirect to the home page or another page
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Object[]> list = userService.list();
        model.addAttribute("users",list);
        return "management-user";
    }

//    @PostMapping("/delete")
//    public String delete(@RequestParam(value = "selectedUsers", required = false) List<Long> selectedUsers){
//        if (selectedUsers != null && !selectedUsers.isEmpty()) {
//            userService.delete(selectedUsers);
//        }
//        return "redirect:/home";
//    }
}
