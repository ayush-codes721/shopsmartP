package ShopSmart.request;

import ShopSmart.dto.CategoryDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {

    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;//qunatity
    private String description;
    private CategoryDTO category;
}
