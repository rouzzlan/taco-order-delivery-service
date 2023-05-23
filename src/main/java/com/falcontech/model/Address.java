package com.falcontech.model;

public record Address(
    String street,
    String city,
    String state,
    String country,
    String zip,
    String hash) {}
