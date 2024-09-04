package ShopSmart.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {

    @Builder.Default
    boolean success=false;
    String message;






}
