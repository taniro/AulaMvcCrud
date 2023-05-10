package tads.eaj.ufrn.aulamvccrud.service;

import org.springframework.stereotype.Service;
import tads.eaj.ufrn.aulamvccrud.model.Postagem;
import tads.eaj.ufrn.aulamvccrud.repository.PostagemRepository;

import java.util.List;

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
}
