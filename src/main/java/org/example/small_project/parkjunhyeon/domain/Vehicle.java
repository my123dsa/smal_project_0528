package org.example.small_project.parkjunhyeon.domain;

import org.example.small_project.ljy.Passenger;

public interface Vehicle {
    String getVehicleNo();
    boolean canBoard();
    Boolean getIn(Passenger p);
    void getOut(Passenger p);
    int getPassengers();
    int getRevenue();
}
