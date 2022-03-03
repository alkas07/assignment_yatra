package com.yatra.safety.controller;

import com.yatra.safety.constants.MessageConstants;
import com.yatra.safety.response.BaseResponse;
import com.yatra.safety.response.LocationDetailsResponse;
import com.yatra.safety.service.CustomerSafetyService;
import com.yatra.safety.util.BaseResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/safety")
public class CustomerSafetyController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerSafetyService customerSafetyService;

    @Autowired
    private MessageConstants message;

    @Autowired
    private BaseResponseUtil baseResponseUtil;

    @GetMapping(value = "/safety-rated-locations/by-coordinates")
    public ResponseEntity getSafetyPlace(@RequestParam Double latitude, @RequestParam Double longitude) {
        log.info("CustomerSafetyController -> getSafetyPlace : ");
        LocationDetailsResponse response = customerSafetyService.getSafetyPlace(latitude, longitude);
        BaseResponse baseResponse = baseResponseUtil.setBaseResponse(response.getLocationDetails(),
                message.SUCCESS_RESPONSE_MESSAGE_CODE, message.SAFE_PLACE_DETAILS_RETRIEVED_SUCCESS_MESSAGE);
        return new ResponseEntity(baseResponse, HttpStatus.OK);

    }

}
