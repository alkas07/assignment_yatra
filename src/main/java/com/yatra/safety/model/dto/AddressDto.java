package com.yatra.safety.model.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
    private String regionCode;
}
