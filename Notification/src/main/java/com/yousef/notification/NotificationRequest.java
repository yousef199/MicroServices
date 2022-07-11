package com.yousef.notification;

import lombok.Data;

@Data
public class NotificationRequest {
    Integer toCustomerId;
    String toCustomerEmail;
    String message;
}

