package gt.edu.url.edunova_spring.service;

import org.springframework.stereotype.Service;
import gt.edu.url.edunova_spring.model.Visitante;

@Service
public class BienvenidaService {

    private static final String INSTITUCION = "EduNova";

    public String mensajeGeneral() {
        return "¡Bienvenido(a) a " + INSTITUCION + "!";
    }

    public String mensajePara(String nombre) {
        Visitante visitante = new Visitante(nombre);
        return "Hola " + visitante.getNombre() + ", bienvenido(a) al Sistema de Gestión de Capacitación " + INSTITUCION + ".";
    }
}