package carnerero.agustin.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Table(name = "tiendas")
@Entity
@Data
public class Tienda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@Column(nullable = false, unique = true)
	private String nombre;	
	@Column(nullable=false)
	private Integer capacidadmaxima;
	public Tienda() {		
		
	}	
	public Tienda(String nombre,int capacidadmaxima) {
		this.nombre=nombre;
		this.capacidadmaxima=capacidadmaxima;
	}
}
