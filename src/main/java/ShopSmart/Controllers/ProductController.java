package ShopSmart.Controllers;

import ShopSmart.request.AddProductRequest;
import ShopSmart.response.ApiResponse;
import ShopSmart.Service.Product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/products")
public class ProductController{


    private final IProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {

        return ResponseEntity.ok(ApiResponse.builder().message("all products").data(productService.getProducts()).build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product) {

        ApiResponse apiResponse = ApiResponse.builder()
                .message("product Added successfully")
                .data(productService.addProduct(product))
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/category")
    public  ResponseEntity<ApiResponse> getProductByCategory(@RequestParam String category){

        ApiResponse apiResponse =ApiResponse
                .builder()
                .message("All "+ category.toUpperCase()+" products")
                .data(productService.getProductByCategory(category))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<ApiResponse> updateProduct(@RequestBody Map<String,Object> updates, @PathVariable Long id){

        ApiResponse apiResponse = ApiResponse
                .builder()
                .message("product updated")
                .data(productService.updateProduct(id,updates))
                .build();

        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Long id) {

        return ResponseEntity.ok(productService.deleteProductById(id));
    }






}
