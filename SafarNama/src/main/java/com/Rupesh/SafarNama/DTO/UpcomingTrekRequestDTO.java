package com.Rupesh.SafarNama.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpcomingTrekRequestDTO {

    @NotBlank(message = "title is required")
    private String title;

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

    public @NotNull(message = "startDate is required") LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull(message = "startDate is required") LocalDate startDate) {
        this.startDate = startDate;
    }

    public @NotNull(message = "endDate is required") LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull(message = "endDate is required") LocalDate endDate) {
        this.endDate = endDate;
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

    public @NotBlank(message = "inclusion is required") String getInclusion() {
        return inclusion;
    }

    public void setInclusion(@NotBlank(message = "inclusion is required") String inclusion) {
        this.inclusion = inclusion;
    }

    public @NotBlank(message = "difficultyLevel is required") String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(@NotBlank(message = "difficultyLevel is required") String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public @NotBlank(message = "meetingPoint is required") String getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(@NotBlank(message = "meetingPoint is required") String meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    @NotBlank(message = "location is required")
    private String location;

    @NotNull(message = "startDate is required")
    private LocalDate startDate;

    @NotNull(message = "endDate is required")
    private LocalDate endDate;

    @NotNull(message = "price is required")
    private Double price;

    @NotBlank(message = "imageUrl is required")
    private String imageUrl;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "itinerary is required")
    private String itinerary;

    @NotBlank(message = "inclusion is required")
    private String inclusion;

    @NotBlank(message = "difficultyLevel is required")
    private String difficultyLevel;

    @NotBlank(message = "meetingPoint is required")
    private String meetingPoint;
}
