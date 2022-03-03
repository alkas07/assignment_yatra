package com.yatra.safety.converter;

import com.amadeus.resources.Location;
import com.yatra.safety.model.dto.AddressDto;
import com.yatra.safety.model.dto.GeoCodeDto;
import com.yatra.safety.model.dto.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter {
    
    public LocationDto locationToLocationDetailsResponseConverter(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setType(location.getType());
        locationDto.setSubType(location.getSubType());
        locationDto.setName(location.getName());
        locationDto.setDetailedName(location.getDetailedName());
        locationDto.setTimeZoneOffset(location.getTimeZoneOffset());
        locationDto.setIataCode(location.getIataCode());
        locationDto.setGeoCode(this.geoCode(location));
        locationDto.setAddress(this.getAddress(location));
        return locationDto;
    }

    private GeoCodeDto geoCode(Location location) {
        GeoCodeDto geoCodeDto = new GeoCodeDto();
        geoCodeDto.setLatitude(location.getGeoCode().getLatitude());
        geoCodeDto.setLongitude(location.getGeoCode().getLongitude());
        return geoCodeDto;
    }

    private AddressDto getAddress(Location location) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCityCode(location.getAddress().getCityCode());
        addressDto.setCityName(location.getAddress().getCityName());
        addressDto.setCountryCode(location.getAddress().getCountryCode());
        addressDto.setCountryName(location.getAddress().getCountryName());
        addressDto.setRegionCode(location.getAddress().getRegionCode());
        return addressDto;
    }
}
