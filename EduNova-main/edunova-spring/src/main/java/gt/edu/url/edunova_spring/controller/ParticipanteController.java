package gt.edu.url.edunova_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gt.edu.url.edunova_spring.model.Participante;
import gt.edu.url.edunova_spring.service.ParticipanteService;

// captura el usuario actual
import java.security.Principal;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public String listar(Model model, HttpSession session, Principal principal) {
        // Captura el usuario autenticado por Spring Security y lo guarda en la sesión
        if (principal != null) {
            session.setAttribute("usuario", principal.getName());
        }

        model.addAttribute("participantes", participanteService.listarTodos());
        return "lista";
    }

    @GetMapping("/nuevo")
    public String nuevoFormulario(Model model) {
        model.addAttribute("participante", new Participante());
        return "formulario";
    }

    // --- CAMBIO CLAVE AQUÍ ---
    @PostMapping
    public String guardar(@ModelAttribute("participante") Participante participante) {
        participanteService.guardar(participante);
        // Redirige a la tabla de gestión de participantes
        return "redirect:/participantes";
    }

    @GetMapping("/{id}/editar")
    public String editarFormulario(@PathVariable Long id, Model model) {
        participanteService.buscarPorId(id).ifPresent(p -> model.addAttribute("participante", p));
        return "formulario";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        participanteService.eliminar(id);
        return "redirect:/participantes";
    }
}