package tads.eaj.ufrn.aulamvccrud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postagem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    String autor;
    String mensagem;
    String titulo;
    String destinatario;

    public void tituloMaiusculo(){
        this.titulo.toUpperCase();
    }
}
