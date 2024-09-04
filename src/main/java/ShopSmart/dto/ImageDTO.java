package ShopSmart.dto;

import jakarta.persistence.Lob;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Blob;
import java.time.LocalDateTime;

@Data
public class ImageDTO {

    private Long id;

    private String fileName;
    private String fileType;

    private String downloadUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
