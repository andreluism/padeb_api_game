/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Matheus
 */

@Entity
public class Pergunta implements Serializable{
	@Id
        @GeneratedValue
	private long id;
        @OneToMany(mappedBy="pergunta", targetEntity = Dica.class)
        @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<Dica> dicas;
	private String categoria;
        @ManyToOne(targetEntity = Estado.class)
        @JoinColumn(name="estado")
        private Estado estado;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public List<Dica> getDicas() {
		return dicas;
	}
	public void setDicas(List<Dica> dicas) {
		this.dicas = dicas;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
	
}
