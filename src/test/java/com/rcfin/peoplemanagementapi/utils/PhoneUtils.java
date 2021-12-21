package com.rcfin.peoplemanagementapi.utils;

import com.rcfin.peoplemanagementapi.dto.request.PhoneDTO;
import com.rcfin.peoplemanagementapi.enums.PhoneType;
import com.rcfin.peoplemanagementapi.models.Phone;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "99999-9999";
    private static final String DDD = "81";
    private static final PhoneType PHONE_TYPE = PhoneType.COMMERCIAL;
    private static final Long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .ddd(DDD)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .idPhone(PHONE_ID)
                .number(PHONE_NUMBER)
                .ddd(DDD)
                .type(PHONE_TYPE)
                .build();
    }
}
