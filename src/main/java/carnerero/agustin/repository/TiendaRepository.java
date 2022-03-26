package carnerero.agustin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carnerero.agustin.entity.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {

}
