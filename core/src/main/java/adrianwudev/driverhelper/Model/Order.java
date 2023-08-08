package adrianwudev.driverhelper.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private int orderId;
    private String city;
    private String district;
    private String address;
    private LocalDateTime orderTime;
    private String pickUpDrop;
    private LocalDateTime pickUpTime;
    private String weekday;
    private String groupName;
    private double amount;
    private double distance;
    @JsonProperty("isException")
    private boolean isException;
    private int repeatCount;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
