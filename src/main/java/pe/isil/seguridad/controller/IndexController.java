package pe.isil.seguridad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.isil.seguridad.model.User;
import pe.isil.seguridad.service.UserService;
import pe.isil.seguridad.service.Welcome;
import pe.isil.seguridad.service.WelcomeImpEsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Qualifier("UserServiceDao")
   @Autowired
  private UserService userService;


    @GetMapping({"/","/inicio"}) //Este implemente el request mapping con el metodo get
     public String index(Model model){

//        List<String> list = new ArrayList<>();
//        list.add("primer elemento");
//        list.add("segundo elemento");
//        int number = getRandomNumber();
//        String name= "Eduardo";
//        model.addAttribute("number", number);
//        model.addAttribute("name" , name);

//        model.addAttribute("Saludo",welcome.sayHello());
//        model.addAttribute("Despido",welcome.GoodBye());

        model.addAttribute("lstUsers", userService.getUsers());

//        model.addAttribute("lstUsers", getUsers());
       return "index";


    }

//    public List<User> getUsers(){
//        List<User> users = new ArrayList<>();
//        User user1 = new User(1,"Juan","Perez","Juan@email.com","1234", LocalDate.of(1990,05,4));
//
//        User user2 = new User(2,"Luis","Garcia","Luis@email.com","1234", LocalDate.of(1995,02,8));
//        User user3 = new User(2,"Maria","Cano","Maria@email.com","1234", LocalDate.of(2002,01,6));
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//        return users;
//    }



    public int getRandomNumber(){
        return (int) (Math.random() * 100);

    }







//    @PostMapping ("/home")
//    public String home(){
//
//        return "home";
//    }

//    @RequestMapping(value = {"/","/inicio"}, method = RequestMethod.GET)
//    public String index(){
//        return "index";
//
//    }

}
