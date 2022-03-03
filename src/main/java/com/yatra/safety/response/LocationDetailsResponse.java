package com.yatra.safety.response;

import com.yatra.safety.model.dto.LocationDto;
import lombok.Data;

import java.util.List;

@Data
public class LocationDetailsResponse {

    private List<LocationDto> locationDetails;
}
