package org.example.small_project.parkjunhyeon.domain;

import org.example.small_project.hyeeun.Policy;
import org.example.small_project.ljy.Passenger;

abstract class AbstractVehicle implements Vehicle {
    protected String vehicleNo;
    protected int passengers;
    protected int maxPassenger;
    protected int revenue;
    protected int fare;

    public AbstractVehicle(String vehicleNo, int maxPassenger, int fare) {
        this.vehicleNo = vehicleNo;
        this.maxPassenger = maxPassenger;
        this.fare = fare;
    }

    @Override
    public String getVehicleNo() { return vehicleNo; }

    @Override
    public boolean canBoard() {
        return passengers < maxPassenger;
    }

    @Override
    public void getIn(Passenger p) {
        if (p.pay(fare)) {
            passengers++;
            revenue += (int)(fare * (1 - Policy.getInstance().getDiscountRate(p.getType())));
            p.setState("탑승");
        }
    }

    @Override
    public void getOut(Passenger p) {
        if (passengers > 0) passengers--;
        p.setState("하차");
    }
}
