package com.yousef.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class NotificationRequest {
    Integer toCustomerId;
    String toCustomerEmail;
    String message;
}

