package tads.eaj.ufrn.aulamvccrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.aulamvccrud.model.Postagem;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, String> {
      List<Postagem> findPostagemByAutor(String autor);
}
