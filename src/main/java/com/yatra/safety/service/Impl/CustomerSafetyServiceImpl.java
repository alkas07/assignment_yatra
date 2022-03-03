package com.yatra.safety.service.Impl;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.yatra.safety.converter.LocationConverter;
import com.yatra.safety.model.dto.LocationDto;
import com.yatra.safety.response.LocationDetailsResponse;
import com.yatra.safety.service.CustomerSafetyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerSafetyServiceImpl implements CustomerSafetyService {

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.secret}")
    private String apiSecret;

    @Autowired
    private LocationConverter locationConverter;

    @Override
    public LocationDetailsResponse getSafetyPlace(Double latitude, Double longitude) {
        LocationDetailsResponse locationDetailsResponse = new LocationDetailsResponse();
        try {
            Amadeus amadeus = Amadeus
                    .builder(apiKey, apiSecret)
                    .build();

//            Location[] locations = amadeus.referenceData.locations.airports.get(Params
//                    .with("latitude", 41.397158)
//                    .and("longitude", 2.160873));
            Location[] locations = amadeus.referenceData.locations.airports.get(Params
                    .with("latitude", latitude)
                    .and("longitude", longitude));

            List<LocationDto> locationDtoList = new ArrayList<>();
            for (Location location1 : locations) {
                locationDtoList.add(locationConverter.locationToLocationDetailsResponseConverter(location1));
            }
            locationDetailsResponse.setLocationDetails(locationDtoList);
        } catch (ResponseException e) {
            e.printStackTrace();
        }
        return locationDetailsResponse;
    }

}
