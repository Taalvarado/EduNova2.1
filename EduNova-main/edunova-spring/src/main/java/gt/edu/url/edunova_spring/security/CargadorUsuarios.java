package gt.edu.url.edunova_spring.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import gt.edu.url.edunova_spring.model.Usuario;
import gt.edu.url.edunova_spring.repository.UsuarioRepository;

@Component
public class CargadorUsuarios implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.password:Admin123*2026}")
    private String passwordAdmin;

    @Value("${app.entrenador.password:Admin123*2026}")
    private String passwordEntrenador;

    public CargadorUsuarios(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        crearSiNoExiste("admin", passwordAdmin, "ADMIN");
        crearSiNoExiste("entrenador", passwordEntrenador, "ENTRENADOR");
    }

    private void crearSiNoExiste(String username, String passwordPlano, String rol) {
        if (usuarioRepository.findByUsername(username).isEmpty()) {
            String hash = passwordEncoder.encode(passwordPlano);
            usuarioRepository.save(new Usuario(username, hash, rol));
        }
    }
}