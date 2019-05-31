package priv.huke.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderExt extends Order {
    private User user;
    private int id;
    private int orderNo;
    private int createUserId;
}
