package gt.edu.url.edunova_spring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import gt.edu.url.edunova_spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}