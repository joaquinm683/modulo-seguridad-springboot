package pe.isil.seguridad.dao;

import org.springframework.stereotype.Repository;
import pe.isil.seguridad.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public List<User> getUsers() throws ClassNotFoundException,SQLException {


        Class.forName("com.mysql.jdbc.Driver");
        //cargar drive;
        Connection connection = null;

        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg", "root", "rootpass");

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select name, lastname, email from users");

        List<User> users = new ArrayList<>();
        int count = 0;
        while (rs.next()){
            User user = new User(
                    count,
                    rs.getString("name"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    "",
                    LocalDate.now()
            );

            count++;
            users.add(user);
        }
        return users;
    }

}
