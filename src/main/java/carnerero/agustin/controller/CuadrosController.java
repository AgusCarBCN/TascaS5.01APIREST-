package carnerero.agustin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import carnerero.agustin.entity.Cuadro;
import carnerero.agustin.exceptions.TiendaFullException;
import carnerero.agustin.exceptions.TiendaNotFoundException;
import carnerero.agustin.repository.CuadroRepository;
import carnerero.agustin.repository.TiendaRepository;



@RestController
public class CuadrosController {

	@Autowired
	private TiendaRepository tiendaRepo;

	@Autowired
	private CuadroRepository cuadroRepo;

//Lista cuadros de tienda
	@GetMapping("/shops/{ID}/pictures")
	public ResponseEntity<List<Cuadro>> listarCuadrosPorTiendaId(@PathVariable(value = "ID") Long idtienda) {
		if (!tiendaRepo.existsById(idtienda)) {
			throw new TiendaNotFoundException(idtienda);
		}
		List<Cuadro> cuadros = cuadroRepo.findByTiendaId(idtienda);

		return new ResponseEntity<>(cuadros, HttpStatus.OK);

	}

//Añadir cuadros a tienda
	@PostMapping("/shops/{ID}/pictures")
	public ResponseEntity<Cuadro> añadirCuadro(@PathVariable(value = "ID") Long idtienda,
			@RequestBody Cuadro cuadrorequest) {		
		Cuadro cuadro = tiendaRepo.findById(idtienda).map(tienda -> {
			cuadrorequest.setTienda(tienda);
			if(cuadroRepo.countByTienda(tienda)>=tienda.getCapacidadmaxima()) {			
				throw new TiendaFullException(idtienda);}
			return cuadroRepo.save(cuadrorequest);
		}).orElseThrow(() -> new TiendaNotFoundException(idtienda));
		return new ResponseEntity<>(cuadro, HttpStatus.OK);

	}
//Borrar todos los cuadros de una tienda
	@DeleteMapping("/shops/{ID}/pictures")
	public ResponseEntity<List<Cuadro>>borrarTodosLosCuadros(@PathVariable(value="ID") Long idtienda){
		if(!tiendaRepo.existsById(idtienda)) {
			throw new TiendaNotFoundException(idtienda);
		}
		cuadroRepo.deleteByTiendaId(idtienda);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}
}
