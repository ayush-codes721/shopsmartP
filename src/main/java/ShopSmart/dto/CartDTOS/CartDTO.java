package ShopSmart.dto.CartDTOS;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class CartDTO {
    private Long id;

    private BigDecimal totalAmount=BigDecimal.ZERO;

    private Set<CartItemDTO> cartItems;
}
