package com.hh.tech_project.model.converter;

import com.hh.tech_project.model.dto.request.SubscriptionRequestDto;
import com.hh.tech_project.model.dto.response.SubscriptionResponseDto;
import com.hh.tech_project.model.entity.Subscription;
import com.hh.tech_project.model.entity.User;

public class SubscriptionConverter {

    public static SubscriptionResponseDto toDto(Subscription subscription) {
        SubscriptionResponseDto dto = new SubscriptionResponseDto();
        dto.setId(subscription.getId());
        dto.setServiceName(subscription.getServiceName());
        return dto;
    }

    public static Subscription toEntity(SubscriptionRequestDto dto, User user) {
        Subscription sub = new Subscription();
        sub.setServiceName(dto.getServiceName());
        sub.setUser(user);
        return sub;
    }
}
