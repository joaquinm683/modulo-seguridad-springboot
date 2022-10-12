package pe.isil.seguridad.service;

import org.springframework.stereotype.Service;

@Service("WelcomeING")
public class WelcomeImpEng implements Welcome{
    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String GoodBye() {
        return "Goodbye";
    }
}
