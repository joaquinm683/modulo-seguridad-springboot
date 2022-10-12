package pe.isil.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

        //Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Crear conexion
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/moduloseg", "root", "rootpass");
        //CREAR STATEMENT
//        Statement st = conexion.createStatement();
//        PreparedStatement pt = conexion.prepareStatement("select * from users where id = ? and username = ?" );
//        pt.setInt(1,3);
//        pt.setString(2,"DNI71234267");

        CallableStatement callSp = conexion.prepareCall("{call validarLogin(?,?,?)}");
        callSp.setString(1,"DNI71234267");
        callSp.setString(2,"123456");
        callSp.registerOutParameter(3,Types.INTEGER);
        //ResultSet resultado = callSp.executeQuery();
        callSp.executeQuery();
        int resultad = callSp.getInt(3);

        if(resultad==1){ System.out.println("Login exitoso");}
        else {System.out.println("Usuario o contrasena no valido");}

//        while(resultado.next()){
//            System.out.println(resultado.getString("name"));
//        }
//
        CallableStatement callSp2 = conexion.prepareCall("{CALL listarAllUsers()}");
        ResultSet resultSet2 = callSp2.executeQuery();
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("username"));
        }

        //====================================

        CallableStatement callSp3 = conexion.prepareCall("{CALL listarUserPerId(?)}");
        callSp3.setInt(1,2);
        ResultSet resultSet3 = callSp3.executeQuery();

        while (resultSet3.next()){
            System.out.println(resultSet3.getString("name"));
        }


    }

}
