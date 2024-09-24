package ShopSmart.Controllers;


import ShopSmart.dto.ImageDTO;
import ShopSmart.model.Image;
import ShopSmart.response.ApiResponse;
import ShopSmart.ShopService.Image.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/images")
public class ImageController {
    private final IImageService imageService;


    @GetMapping("/{id}")
    ResponseEntity<ApiResponse> getImageById(@PathVariable Long id) {

        ImageDTO imageDTO = imageService.getImageByID(id);
        ApiResponse apiResponse = ApiResponse
                .builder()
                .message("image")
                .data(imageDTO)
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/upload")
    ResponseEntity<ApiResponse> addImages(@RequestParam List<MultipartFile> files, @RequestParam Long pid) throws SQLException, IOException {

        if (files == null) {
            throw new RuntimeException("file is empty");
        }
        List<ImageDTO> imageDTOS = imageService.saveImages(files, pid);

        ApiResponse apiResponse = ApiResponse.builder().message("images addedd successfully").data(imageDTOS).build();

        return ResponseEntity.ok(apiResponse);

    }

    @GetMapping("/image/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable Long id) {
        Image image = imageService.findImageById(id);

        // Fetching the image as a byte array
        byte[] imageBytes = image.getImage();

        // Wrapping it in ByteArrayResource
        ByteArrayResource resource = new ByteArrayResource(imageBytes);

        // Returning the image with appropriate headers
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + image.getFileName() + "\"")
                .body(resource);

    }




}
