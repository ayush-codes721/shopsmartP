package ShopSmart.Controllers;

import ShopSmart.dto.CartDTOS.CartDTO;
import ShopSmart.response.ApiResponse;
import ShopSmart.response.CartApiResponse;
import ShopSmart.service.Cart.ICartItemService;
import ShopSmart.service.Cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/cart")
@RequiredArgsConstructor
public class CartController {

    private final ICartService cartService;
    private final ICartItemService cartItemService;



    @GetMapping("/{cartId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long cartId) {
      
        CartDTO cartDTO = cartService.getCart(cartId);
        return ResponseEntity.ok(cartDTO);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<ApiResponse> clearCart() {
        ApiResponse response = cartService.clearCart();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cartId}/total")
    public ResponseEntity<BigDecimal> getTotalPrice(@PathVariable Long cartId) {
        BigDecimal totalPrice = cartService.getTotalPrice(cartId);
        return ResponseEntity.ok(totalPrice);
    }

    @PostMapping("/{cartId}/addItem")
    public ResponseEntity<CartApiResponse> addItemToCart(
            @RequestParam Long productId,
            @PathVariable Long cartId,
            @RequestParam int quantity) {
        CartApiResponse response = cartItemService.addItemToCart(productId, cartId, quantity);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{cartId}/removeItem")
    public ResponseEntity<CartApiResponse> removeItemFromCart(
            @PathVariable Long cartId,
            @RequestParam Long productId) {
        CartApiResponse response = cartItemService.removeItemFormCart(cartId, productId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{cartId}/updateItemQuantity")
    public ResponseEntity<CartApiResponse> updateItemQuantity(

            @PathVariable Long cartId,
            @RequestParam Long productId,
            @RequestParam int quantity) {
        CartApiResponse response = cartItemService.updateItemQuantity(cartId, productId, quantity);
        return ResponseEntity.ok(response);
    }
}
