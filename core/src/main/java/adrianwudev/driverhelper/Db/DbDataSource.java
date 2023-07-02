package adrianwudev.driverhelper.Db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DbDataSource {

    private final ConnectionSetting connectionSetting;

    @Autowired
    public DbDataSource(ConnectionSetting connectionSetting) {
        this.connectionSetting = connectionSetting;
    }

    public Connection getConnection() throws SQLException {
        // Create DB connection
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(connectionSetting.getUrl());
        dataSource.setUsername(connectionSetting.getUsername());
        dataSource.setPassword(connectionSetting.getPassword());
        dataSource.setDriverClassName(connectionSetting.getDriverClassName());

        return dataSource.getConnection();
    }


}
