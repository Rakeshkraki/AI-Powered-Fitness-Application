package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    public final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ActivityResponse crateActivity(ActivityRequest activityRequest) {

        Activity activity = new Activity();
        activity.setUserId(activityRequest.getUserId());
        activity.setType(activityRequest.getType());
        activity.setDuration(activityRequest.getDuration());
        activity.setCaloriesBurned(activityRequest.getCaloriesBurned());
        activity.setStartTime(activityRequest.getStartTime());
        activity.setAdditionalMatrics(activityRequest.getAdditionalMatrics());

        Activity savedActivity = activityRepository.save(activity);
        return mapSavedActivity(savedActivity);

    }

    private ActivityResponse mapSavedActivity(Activity activity) {
        ActivityResponse res = new ActivityResponse();
        res.setId(activity.getId());
        res.setUserId(activity.getUserId());
        res.setType(activity.getType());
        res.setDuration(activity.getDuration());
        res.setCaloriesBurned(activity.getCaloriesBurned());
        res.setStartTime(activity.getStartTime());
        res.setAdditionalMatrics(activity.getAdditionalMatrics());
        res.setCreatedAt(activity.getCreatedAt());
        res.setUpdatedAt(activity.getUpdatedAt());

        return res;
    }


    public List<ActivityResponse> getUserActivities(String userId) {

        List<Activity> activities = activityRepository.findByUserId(userId);
        return activities.stream()
                .map(this::mapSavedActivity)
                .collect(Collectors.toList());
    }
}
 