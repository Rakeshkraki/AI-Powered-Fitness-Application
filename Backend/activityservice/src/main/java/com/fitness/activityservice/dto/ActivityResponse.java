package com.fitness.activityservice.dto;

import com.fitness.activityservice.model.ActivityType;

import java.time.LocalDateTime;
import java.util.Map;

public class ActivityResponse {

    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMatrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ActivityResponse() {
    }

    public ActivityResponse(String id, String userId, ActivityType type, Integer duration, Integer caloriesBurned, LocalDateTime startAt, Map<String, Object> additionalMatrics, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.startTime = startAt;
        this.additionalMatrics = additionalMatrics;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Integer caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Map<String, Object> getAdditionalMatrics() {
        return additionalMatrics;
    }

    public void setAdditionalMatrics(Map<String, Object> additionalMatrics) {
        this.additionalMatrics = additionalMatrics;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
