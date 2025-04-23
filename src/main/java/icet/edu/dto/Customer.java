package icet.edu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {


    private Long iD;

    private  String name;

    private  String email;

    private String phoneNumber;

}
