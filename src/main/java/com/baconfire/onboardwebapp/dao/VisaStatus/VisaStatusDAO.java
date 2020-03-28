package com.baconfire.onboardwebapp.dao.VisaStatus;

public interface VisaStatusDAO {
    int getIDByType(String type);

    String getVisaStatusByID(int visaStatusId);
}
