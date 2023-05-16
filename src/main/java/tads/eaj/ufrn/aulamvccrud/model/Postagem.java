package tads.eaj.ufrn.aulamvccrud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postagem {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    String id;
    @Email
    String autor;
    String mensagem;
    @Size(max = 20, min = 4)
    String titulo;
    @NotBlank
    String destinatario;

    public void tituloMaiusculo(){
        this.titulo.toUpperCase();
    }
}
