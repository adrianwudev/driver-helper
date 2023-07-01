package adrianwudev.driverhelper.Db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class ConnectionSetting {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public ConnectionSetting(String url, String username, String password, String driverClassName) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
    }
}
