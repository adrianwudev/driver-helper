package adrianwudev.driverhelper.Response;

import adrianwudev.driverhelper.Codes.CodeMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse<T> {
    private int statusCode;
    private T data;
    private String message;
    public JsonResponse (int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
        setMessage(statusCode);
    }
    public JsonResponse (int statusCode) {
        this.statusCode = statusCode;
        setMessage(statusCode);
    }

    private void setMessage(int statusCode) {
        this.message = CodeMap.getMessage(statusCode);
    }
}
