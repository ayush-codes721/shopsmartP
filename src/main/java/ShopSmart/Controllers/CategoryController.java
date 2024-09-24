package ShopSmart.Controllers;

import ShopSmart.dto.CategoryDTO;
import ShopSmart.response.ApiResponse;
import ShopSmart.ShopService.Category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategories() {
        ApiResponse apiResponse = ApiResponse
                .builder()
                .message("all categories")
                .data(categoryService.getAllCategories())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {

        ApiResponse apiResponse = ApiResponse
                .builder()
                .message("category by id")
                .data(categoryService.getCategoryById(id))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/name")
    public ResponseEntity<ApiResponse> getCategoryByName(@RequestParam String name) {

        ApiResponse apiResponse = ApiResponse.builder()
                .message("catergory by name")
                .data(categoryService.getCategoryByName(name))
                .build();

        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDTO category) {

        ApiResponse apiResponse = ApiResponse.builder()
                .message("category added succesfully")
                .data(categoryService.addCategory(category))
                .build();

        return ResponseEntity.ok(apiResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@RequestBody Map<String, Object> updates, @PathVariable Long id) {

        ApiResponse apiResponse = ApiResponse.builder()
                .message("data updated")
                .data(categoryService.updateCategory(updates, id))
                .build();


        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Long id) {

       return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

}
