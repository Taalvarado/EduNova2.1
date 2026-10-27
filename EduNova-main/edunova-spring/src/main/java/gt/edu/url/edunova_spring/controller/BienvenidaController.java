package gt.edu.url.edunova_spring.controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidaController {

    @GetMapping("/api/saludo")
    public String saludo() {
        return "¡Bienvenido(a) a EduNova!";
    }

    @GetMapping("/api/bienvenida")
    public String bienvenida(@RequestParam(defaultValue = "visitante") String nombre) {
        return "Hola " + nombre + ", bienvenido(a) al Sistema de Gestión de Capacitación EduNova.";
    }
}