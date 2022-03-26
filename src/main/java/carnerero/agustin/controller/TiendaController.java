package carnerero.agustin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import carnerero.agustin.entity.Tienda;
import carnerero.agustin.repository.TiendaRepository;


@RestController
public class TiendaController {

	@Autowired
	private TiendaRepository tiendaRepo;

	// Crear tienda
	@PostMapping("/POST/shops")
	public ResponseEntity<Tienda> crearTienda(@RequestBody Tienda tienda) {
		try {
			return new ResponseEntity<>(tiendaRepo.save(tienda), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Listar tiendas: Lista tiendas con su nombre y capacidad

	@GetMapping("/GET/shops")
	public ResponseEntity<List<Tienda>> listarTiendas() {
		try {
			List<Tienda> listaDeTiendas = tiendaRepo.findAll();
			if (listaDeTiendas.isEmpty() || listaDeTiendas.size() == 0) {
				return new ResponseEntity<List<Tienda>>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Tienda>>(listaDeTiendas, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
