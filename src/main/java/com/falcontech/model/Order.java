package com.falcontech.model;

import java.util.UUID;

public record Order(
    String id,
    UUID uuid,
    String name,
    String email,
    String ccardRef,
    String addrRef) {}
