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
public class ListHouseResponse {
    private ServiceStatus serviceStatus;
    private List<House> list;


}