package tads.eaj.ufrn.aulamvccrud.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.aulamvccrud.model.Usuario;
import tads.eaj.ufrn.aulamvccrud.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void create(Usuario u){
        this.repository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> user = repository.findUsuarioByLogin(username);
        if (user.isPresent()){
            return user.get();
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
