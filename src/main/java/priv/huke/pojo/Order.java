package priv.huke.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Order {
    private int id;
    private int orderNo;
    private int createUserId;
}
