package domain;

import domain.app.RepoProductoBaseJPA;
import domain.models.entities.ProductoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ApplicationLicuadora {

    @Autowired
    RepositoryRestConfiguration config;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLicuadora.class, args);
    }

    @Bean
    public CommandLineRunner productoBase(RepoProductoBaseJPA repo) {
        config.exposeIdsFor(ProductoBase.class);

        return (args) -> {
            repo.save(new ProductoBase("Remera"));
            repo.save(new ProductoBase("Pantalon"));
        };
    }
}
