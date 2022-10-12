package pe.isil.seguridad.service;

import org.springframework.stereotype.Service;

@Service("WelcomeESP")
public class WelcomeImpEsp implements Welcome {


    @Override
    public String sayHello() {
        return "Hola";
    }

    @Override
    public String GoodBye() {
        return "Adios";
    }
}
