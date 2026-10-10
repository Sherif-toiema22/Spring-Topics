package com.sherif.Hibernate.entity;

public record CreateUserRequest(
        String firstName,
        String lastName,

        String email
) {}