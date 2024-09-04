package ShopSmart.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartApiResponse {

    private boolean success;
    private  String msg;
}
