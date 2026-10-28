package gt.edu.url.edunova_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CapacitacionController {

    @GetMapping("/capacitaciones")
    public String verCapacitaciones() {
        // Redirige a la vista HTML con los estilos de Guatex
        return "capacitaciones";
    }
}
    

