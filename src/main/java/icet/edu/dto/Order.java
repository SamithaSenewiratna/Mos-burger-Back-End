package icet.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private Long id;
    private Long customerId;
    private LocalDate date;
    private LocalTime time;
    private List<OrderDetail> details;



}
