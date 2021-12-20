package com.rcfin.peoplemanagementapi.dto.request;

import com.rcfin.peoplemanagementapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long idPhone;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(max = 3)
    private String ddd;

    @NotEmpty
    @Size(max = 10)
    private String number;
}
