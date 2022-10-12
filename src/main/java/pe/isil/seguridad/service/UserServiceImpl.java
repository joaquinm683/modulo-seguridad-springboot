package pe.isil.seguridad.service;


import org.springframework.stereotype.Service;
import pe.isil.seguridad.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("UserServiceLocal")
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUsers() {


        //List<User> users = new ArrayList<>();
        User user1 = new User(1,"Juan","Perez","Juan@email.com","1234", LocalDate.of(1990,05,4));

        User user2 = new User(2,"Luis","Garcia","Luis@email.com","1234", LocalDate.of(1995,02,8));
        User user3 = new User(2,"Maria","Cano","Maria@email.com","1234", LocalDate.of(2002,01,6));



        return List.of(user1,user2,user3);
    }
}
