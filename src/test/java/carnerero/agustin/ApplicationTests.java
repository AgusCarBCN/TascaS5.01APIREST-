package carnerero.agustin;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import carnerero.agustin.entity.Cuadro;
import carnerero.agustin.entity.Tienda;
import carnerero.agustin.repository.CuadroRepository;
import carnerero.agustin.repository.TiendaRepository;

@SpringBootTest
class ApplicationTests {
@Autowired  
TiendaRepository tiendaRepo;
@Autowired
CuadroRepository cuadroRepo;

	@Test void crearTienda() {
		Tienda tienda=new Tienda();		
		tienda.setCapacidadmaxima(120);
		tienda.setNombre("WhiteCollarLondres");
		tiendaRepo.save(tienda);
		long idTienda=tienda.getId();			
		assertThat(tiendaRepo.findById(idTienda));
	}
	
	@Test
	public void listarTiendas() {
		List<Tienda> tiendas=tiendaRepo.findAll();
		assertThat(tiendas).size().isGreaterThan(0);
	}
	@Test
	public void listarCuadrosPorTienda() {
		Long idTienda=1L;
		List<Cuadro>cuadros=cuadroRepo.findByTiendaId(idTienda);
		assertThat(cuadros).size().isNotEqualTo(0);
		}
	
	@Test
	public void borrarCuadrosTienda() {		
		long idTienda=3L;	
		Optional<Cuadro>cuadros=cuadroRepo.findById(idTienda);
		cuadroRepo.deleteByTiendaId(idTienda);
		assertThat(cuadros.isEmpty());		
	}	
	
}
