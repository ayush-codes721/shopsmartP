package ShopSmart.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private  String name;
    private String username;

    private  String password;


}
