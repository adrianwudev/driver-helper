package adrianwudev.driverhelper.Config;

import adrianwudev.driverhelper.Qualifier.DefaultPage;
import adrianwudev.driverhelper.Qualifier.DefaultPageSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Connection connection() throws SQLException {
        String url = environment.getProperty("spring.datasource.url");
        String username = environment.getProperty("spring.datasource.username");
        String password = environment.getProperty("spring.datasource.password");
        String driverClassName = environment.getProperty("spring.datasource.driver-class-name");

        // Create DB connection
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        return dataSource.getConnection();
    }

    @Value("${order.default.page}")
    public int defaultPage;
    @Bean
    @DefaultPage
    public int defaultPage(){return defaultPage;}

    @Value("${order.default.page-size}")
    public int defaultPageSize;

    @Bean
    @DefaultPageSize
    public int defaultPageSize(){return defaultPageSize;}

}