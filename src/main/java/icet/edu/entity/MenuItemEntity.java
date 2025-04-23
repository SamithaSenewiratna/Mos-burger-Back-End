package icet.edu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menu_items")
public class MenuItemEntity {
    @Id
    private String itemCode;
    private String itemName;
    private double price;
    private int discount;
    private String img;
    private String category;
}
