package icet.edu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {

    private String itemCode;
    private int qty;
    private double unitPrice;


}
