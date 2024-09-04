package ShopSmart.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;//qunatity
    private String description;
    private CategoryDTO category;
    private List<ImageDTO> images;
}
