package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Geo {
    private final UUID deviceId;

    @NotBlank
    private final double latitude, longitude;

    public Geo(@JsonProperty("deviceId") UUID deviceId,
               @JsonProperty("latitude")double latitude,
               @JsonProperty("longitude")double longitude) {

        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
