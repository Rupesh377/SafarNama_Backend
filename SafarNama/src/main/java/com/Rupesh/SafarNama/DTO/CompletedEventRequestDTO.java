package com.Rupesh.SafarNama.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CompletedEventRequestDTO {

    @NotBlank(message = "Title is equired")
    private String title;

    @NotBlank(message = "location is required")
    private String location;

    public @NotBlank(message = "Title is equired") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is equired") String title) {
        this.title = title;
    }

    public @NotBlank(message = "location is required") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "location is required") String location) {
        this.location = location;
    }

    public @NotBlank(message = "duration is required") String getDuration() {
        return duration;
    }

    public void setDuration(@NotBlank(message = "duration is required") String duration) {
        this.duration = duration;
    }

    public @NotNull(message = "price is required") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "price is required") Double price) {
        this.price = price;
    }

    public @NotBlank(message = "imageUrl is required") String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotBlank(message = "imageUrl is required") String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public @NotBlank(message = "description is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "description is required") String description) {
        this.description = description;
    }

    public @NotBlank(message = "itinerary is required") String getItinerary() {
        return itinerary;
    }

    public void setItinerary(@NotBlank(message = "itinerary is required") String itinerary) {
        this.itinerary = itinerary;
    }

    public @NotNull(message = "totalMembers is required") Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(@NotNull(message = "totalMembers is required") Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    @NotBlank(message = "duration is required")
    private String duration;

    @NotNull(message = "price is required")
    private Double price;

    @NotBlank(message = "imageUrl is required")
    private String imageUrl;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "itinerary is required")
    private String itinerary;

    @NotNull(message = "totalMembers is required")
    private Integer totalMembers;

}
