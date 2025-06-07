package service;

import model.Animal;
import repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> listarTodos() {
        return repository.findAll();
    }

    public Animal buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal cadastrar(Animal animal) {
        return repository.save(animal);
    }

    public Animal atualizar(Long id, Animal animalAtualizado) {
        Animal animal = buscarPorId(id);
        animal.setNome(animalAtualizado.getNome());
        animal.setTipo(animalAtualizado.getTipo());
        // Atualizar outros campos...
        return repository.save(animal);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}