package com.sena.disocc.modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int idUsuario;
	@Column(name = "CONTRASENA")
	private String contrasena;
	@Column(name = "CORREO")
	private String email;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "NUMERO_DOCUMENTO")
	private int numeroDocumento;
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column(name = "TELEFONO")
	private int telefono;
	
	@ManyToOne
	@JoinColumn(name = "FK_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
	private TipoDocumento tipoDocumento;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles" , joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Rol> roles = new HashSet<>();
 
    public void addRole(Rol role) {
        this.roles.add(role);
}
	@ManyToOne
	@JoinColumn(name = "FK_ID_ESTADO", referencedColumnName = "ID_ESTADO")
	private Estado idEstado;
	
	@OneToMany(targetEntity = Peticion.class, mappedBy = "usuario")
	private List<Peticion> listaPeticio;
	
	@OneToMany(targetEntity = Respuesta.class, mappedBy = "FK_ID_USUARIO")
	private List<Respuesta>listaRespuesta;
	
	@OneToMany(targetEntity = Venta.class, mappedBy = "usuario")
	private List<Venta> listaVentas;

	
	public Usuario(String primerNombre, String segundoApellido, String primerApellido, String segundoNombre,
			String direccion, int telefono, String email,int numeroDocumento,TipoDocumento tipoDocumento, String contrasena, Set<Rol> roles) {
	
		super();
		this.contrasena = contrasena;
		this.email = email;
		this.direccion = direccion;
		this.numeroDocumento = numeroDocumento;
		this.primerApellido = primerApellido;
		this.primerNombre = primerNombre;
		this.segundoApellido = segundoApellido;
		this.segundoNombre = segundoNombre;
		this.telefono = telefono;
		this.tipoDocumento = tipoDocumento;
		this.roles = roles;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public String Fullname() {
		return this.getPrimerNombre() + " " + this.getPrimerApellido();
	}
		
	 public boolean hasRol(String roleName) {
	        Iterator<Rol> iterator = this.roles.iterator();
	        while (iterator.hasNext()) {
	            Rol role = iterator.next();
	            if (role.getNomRol().equals(roleName)) {
	                return true;
	            }
	        }         
	        return false;
	    }

}
