package adrianwudev.driverhelper.Codes;

import java.util.HashMap;
import java.util.Map;

public class CodeMap {
    private static final String OK = "OK";
    private static final String InternalError = "Internal Error";
    private static final String Unknown = "Unknown";
    private static final Map<Integer, String> codeToMessageMap = new HashMap<>();

    static {
        codeToMessageMap.put(StatusCode.OK.getCode(), OK);
        codeToMessageMap.put(StatusCode.INTERNAL_ERROR.getCode(), InternalError);
        codeToMessageMap.put(StatusCode.UNKNOWN.getCode(), Unknown);
    }

    public static String getMessage(int code) {
        return codeToMessageMap.getOrDefault(code, Unknown);
    }
}
