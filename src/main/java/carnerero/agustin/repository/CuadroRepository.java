package carnerero.agustin.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carnerero.agustin.entity.Cuadro;
import carnerero.agustin.entity.Tienda;

@Repository
public interface CuadroRepository extends JpaRepository<Cuadro, Long> {

	public List<Cuadro>findByTiendaId(Long id);
	@Transactional
	public void deleteByTiendaId(Long id);
	int countByTienda(Tienda tienda);
}
