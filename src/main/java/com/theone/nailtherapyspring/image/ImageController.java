package com.theone.nailtherapyspring.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("description") String description, @RequestParam("uploadedBy") Long uploadedBy) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        try {
            Image image = new Image();
            image.setImageData(file.getBytes());
            image.setDescription(description);
            image.setUploadedBy(uploadedBy);
            imageService.saveImage(image);
            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> getImage(@PathVariable Long id) {
        Image image = imageService.getImage(id);
        if (image != null) {
            ImageDTO imageDTO = new ImageDTO(image.getImageData(), image.getDescription(), image.getUploadedBy());
            return ResponseEntity.ok().body(imageDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static class ImageDTO {
        private byte[] data;
        private String description;
        private Long uploadedBy;

        public ImageDTO(byte[] data, String description, Long uploadedBy) {
            this.data = data;
            this.description = description;
            this.uploadedBy = uploadedBy;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getUploadedBy() {
            return uploadedBy;
        }

        public void setUploadedBy(Long uploadedBy) {
            this.uploadedBy = uploadedBy;
        }
    }
}
