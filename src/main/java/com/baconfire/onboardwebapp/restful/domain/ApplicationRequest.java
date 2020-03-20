package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.Address;
import com.baconfire.onboardwebapp.domain.Person;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApplicationRequest {
    private PersonRequest person;
    private AddressRequest address;
}
