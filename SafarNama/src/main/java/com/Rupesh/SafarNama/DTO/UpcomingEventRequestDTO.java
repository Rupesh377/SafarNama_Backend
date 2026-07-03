package com.Rupesh.SafarNama.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class UpcomingEventRequestDTO {


    public @NotBlank(message = "title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "title is required") String title) {
        this.title = title;
    }

    public @NotBlank(message = "location is required") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "location is required") String location) {
        this.location = location;
    }

    public @NotNull(message = "time is required") LocalDateTime getTime() {
        return time;
    }

    public void setTime(@NotNull(message = "time is required") LocalDateTime time) {
        this.time = time;
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

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "location is required")
    private String location;

    @NotNull(message = "time is required")
    private LocalDateTime time;

    @NotNull(message = "price is required")
    private Double price;

    @NotBlank(message = "imageUrl is required")
    private String imageUrl;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "itinerary is required")
    private String itinerary;
}
