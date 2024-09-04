package ShopSmart.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {

    private Long userID;
    private String accessToken;
}
