package adrianwudev.driverhelper.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResult<T> {
    private int total;
    private int page;
    private int pageSize;
    private List<T> results;
}
