package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.Contact;
import com.baconfire.onboardwebapp.domain.Employee;
import com.baconfire.onboardwebapp.domain.Facility;
import com.baconfire.onboardwebapp.domain.House;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HouseHRResponse {
    private ServiceStatus serviceStatus;
    private House house;
    private Contact contact;
    private List<Employee> list;
    private List<Facility> facilities;

}
