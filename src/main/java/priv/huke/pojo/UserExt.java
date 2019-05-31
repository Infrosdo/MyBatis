package priv.huke.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserExt extends User{
    private List<Order> orders;

    private int id;
    private String name;
    private int age;
}
