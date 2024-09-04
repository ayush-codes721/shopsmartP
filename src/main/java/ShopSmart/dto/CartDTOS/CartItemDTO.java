package ShopSmart.dto.CartDTOS;

import ShopSmart.dto.ProductDTO;
import ShopSmart.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDTO {

    private Long id;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private ProductDTO product;
}
