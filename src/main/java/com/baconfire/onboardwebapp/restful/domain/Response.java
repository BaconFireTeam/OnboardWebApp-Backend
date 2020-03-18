package com.baconfire.onboardwebapp.restful.domain;

import com.baconfire.onboardwebapp.domain.User;
import com.baconfire.onboardwebapp.restful.common.ServiceStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private ServiceStatus serviceStatus;
    private User user;
}
