package adrianwudev.driverhelper.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchCondition {

    private String city;
    private String district;
    private String weekDay;
    private boolean isException;
}
