package org.example.small_project.parkjunhyeon.domain;

import org.example.small_project.ljy.Passenger;

public interface Vehicle {
    String getVehicleNo();
    boolean canBoard();
    void getIn(Passenger p);
    void getOut(Passenger p);
}
