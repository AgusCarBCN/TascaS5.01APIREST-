package carnerero.agustin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Table(name="cuadros")
@Entity
@Data
@ToString

public class Cuadro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(nullable = false)
	private double precio;
	@Column(nullable=false)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fechaentrada;
	private String autor="anonimo";	
	public Cuadro() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "tiendaid", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  
	private Tienda tienda;
}

