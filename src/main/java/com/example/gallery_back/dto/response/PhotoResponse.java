package com.example.gallery_back.dto.response;

import com.example.gallery_back.entity.Photo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PhotoResponse {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;

    public static PhotoResponse from(Photo photo) {
        return PhotoResponse.builder()
                .id(photo.getId())
                .title(photo.getTitle())
                .description(photo.getDescription())
                .imageUrl(photo.getImageUrl())
                .build();
    }
}
