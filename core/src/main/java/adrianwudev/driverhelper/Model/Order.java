package adrianwudev.driverhelper.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private long orderId;
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
    private boolean isException;
    private int repeatCount;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
