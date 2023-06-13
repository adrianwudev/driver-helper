package adrianwudev.driverhelper.Codes;

import lombok.Getter;
import lombok.Setter;

import java.beans.PropertyVetoException;

public enum StatusCode {
    OK(200),
    INTERNAL_ERROR(500),
    UNKNOWN(7000);

    private final int code;

    StatusCode (int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
