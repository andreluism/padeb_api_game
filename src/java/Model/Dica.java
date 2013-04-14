package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Matheus
 */

@Entity
public class Dica implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String dica;
    @Column(name="id_pergunta")
    private long pergunta;
    public long getId() {
            return id;
    }
    public void setId(long id) {
            this.id = id;
    }

    public String getDica() {
            return dica;
    }
    public void setDica(String dica) {
            this.dica = dica;
    }

    public long getPergunta() {
        return pergunta;
    }

    public void setPergunta(long pergunta) {
        this.pergunta = pergunta;
    }
}
