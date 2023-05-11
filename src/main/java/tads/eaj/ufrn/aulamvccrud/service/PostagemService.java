package tads.eaj.ufrn.aulamvccrud.service;

import org.springframework.stereotype.Service;
import tads.eaj.ufrn.aulamvccrud.model.Postagem;
import tads.eaj.ufrn.aulamvccrud.repository.PostagemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    private PostagemRepository repository;

    public PostagemService(PostagemRepository repository) {
        this.repository = repository;
    }

    public void save(Postagem p){
        p.tituloMaiusculo();
        repository.save(p);
    }

    public List<Postagem> findAll(){
        return repository.findAll();
    }

    public Optional<Postagem> findById(Integer id){
        return repository.findById(id);
    }
}








