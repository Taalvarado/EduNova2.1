package gt.edu.url.edunova_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.edu.url.edunova_spring.model.Participante;
import gt.edu.url.edunova_spring.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> listarTodos() {
        return participanteRepository.findAll();
    }

    @SuppressWarnings("null")
    public Participante guardar(Participante participante) {
        return participanteRepository.save(participante);
    }

    @SuppressWarnings("null")
    public Optional<Participante> buscarPorId(Long id) {
        return participanteRepository.findById(id);
    }

    @SuppressWarnings("null")
    public void eliminar(Long id) {
        participanteRepository.deleteById(id);
    }
}