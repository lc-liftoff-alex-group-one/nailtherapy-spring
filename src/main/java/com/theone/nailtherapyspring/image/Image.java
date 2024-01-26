package com.theone.nailtherapyspring.image;

import com.theone.nailtherapyspring.models.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "inspopix")
public class Image extends AbstractEntity {
    private String description;
    private Long uploadedBy;

    @Lob
    @Column(name = "imagedata")
    private byte[] imageData;

    public Image() {
    }

    public Image(String description, Long uploadedBy, byte[] imageData) {
        this.description = description;
        this.uploadedBy = uploadedBy;
        this.imageData = imageData;
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

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

}
