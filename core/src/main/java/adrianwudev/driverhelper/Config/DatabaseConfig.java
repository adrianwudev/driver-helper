package adrianwudev.driverhelper.Config;

import adrianwudev.driverhelper.Qualifier.DefaultPage;
import adrianwudev.driverhelper.Qualifier.DefaultPageSize;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DatabaseConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DSLContext dslContext() {

        String url = environment.getProperty("spring.datasource.url");
        String username = environment.getProperty("spring.datasource.username");
        String password = environment.getProperty("spring.datasource.password");

        // Print database connection properties
        log.info("Database URL: " + url);
        log.info("Username: " + username);

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        // Create HikariCP
        DataSource dataSource = new HikariDataSource(config);

        // Create DSLContext of JOOQ
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }

    @Value("${order.default.page}")
    public int defaultPage;

    @Bean
    @DefaultPage
    public int defaultPage() {
        return defaultPage;
    }

    @Value("${order.default.page-size}")
    public int defaultPageSize;

    @Bean
    @DefaultPageSize
    public int defaultPageSize() {
        return defaultPageSize;
    }

}
