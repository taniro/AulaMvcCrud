package tads.eaj.ufrn.aulamvccrud.repository;

import org.springframework.data.repository.CrudRepository;
import tads.eaj.ufrn.aulamvccrud.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Optional<Usuario> findUsuarioByLogin(String login);
}
