package carnerero.agustin.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import carnerero.agustin.entity.Tienda;
import carnerero.agustin.repository.TiendaRepository;
@Configuration
public class LoadingData {
	@Bean
	public CommandLineRunner loadData(TiendaRepository tiendaRepo) {
		return (args) -> {
			// save a couple of customers
			tiendaRepo.save(new Tienda("WhiteCollarBarcelona", 120));
			tiendaRepo.save(new Tienda("WhiteCollarMadrid", 110));
			tiendaRepo.save(new Tienda("WhiteCollarParis", 520));
			tiendaRepo.save(new Tienda("WhiteCollarLondres", 3));
			
		};
	}
}