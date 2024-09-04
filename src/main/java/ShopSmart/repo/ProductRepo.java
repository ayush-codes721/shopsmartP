package ShopSmart.repo;

import ShopSmart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByCategoryName(String categoryName); // Assumes Category has a name field

    List<Product> findByBrand(String brand); // Updated to match 'brand' in Product

    List<Product> findByBrandAndName(String brand, String name); // Updated to match 'brand' and 'name' in Product

    Long countByCategory_NameAndBrand(String categoryName, String brand);

}
