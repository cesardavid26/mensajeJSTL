package mensajeJPA.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String user;

	private String clave;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario1")
	private List<Mensaje> mensajes1;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario2")
	private List<Mensaje> mensajes2;

	public Usuario() {
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Mensaje> getMensajes1() {
		return this.mensajes1;
	}

	public void setMensajes1(List<Mensaje> mensajes1) {
		this.mensajes1 = mensajes1;
	}

	public Mensaje addMensajes1(Mensaje mensajes1) {
		getMensajes1().add(mensajes1);
		mensajes1.setUsuario1(this);

		return mensajes1;
	}

	public Mensaje removeMensajes1(Mensaje mensajes1) {
		getMensajes1().remove(mensajes1);
		mensajes1.setUsuario1(null);

		return mensajes1;
	}

	public List<Mensaje> getMensajes2() {
		return this.mensajes2;
	}

	public void setMensajes2(List<Mensaje> mensajes2) {
		this.mensajes2 = mensajes2;
	}

	public Mensaje addMensajes2(Mensaje mensajes2) {
		getMensajes2().add(mensajes2);
		mensajes2.setUsuario2(this);

		return mensajes2;
	}

	public Mensaje removeMensajes2(Mensaje mensajes2) {
		getMensajes2().remove(mensajes2);
		mensajes2.setUsuario2(null);

		return mensajes2;
	}

}