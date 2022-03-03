package com.yatra.safety.model.dto;

import lombok.Data;

@Data
public class LocationDto {

    private String type;
    private String subType;
    private String name;
    private String detailedName;
    private String timeZoneOffset;
    private String iataCode;
    private GeoCodeDto geoCode;
    private AddressDto address;

}
