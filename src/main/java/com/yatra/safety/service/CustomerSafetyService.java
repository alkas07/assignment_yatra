package com.yatra.safety.service;

import com.yatra.safety.response.LocationDetailsResponse;


public interface CustomerSafetyService {

    LocationDetailsResponse getSafetyPlace(Double latitude, Double longitude);
}
