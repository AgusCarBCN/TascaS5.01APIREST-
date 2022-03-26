package carnerero.agustin.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Component
@EnableWebMvc
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(

				"Tasca S5.01 Spring Java API REST",
				"Api Rest de una franquicia de tiendas ilegales "
				+ "Cada tienda tiene un nombre y un identificador único "
				+ "Los cuadros tienen un nombre ,identificador único ,un precio y un autor que puede ser anónimo "
				,
				"1.0", null, null, null, null, Collections.emptyList());
	}
}
