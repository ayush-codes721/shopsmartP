package ShopSmart.exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String insufficientStockAvailable) {
        super(insufficientStockAvailable);
    }
}
