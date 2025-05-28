package org.example.small_project.jhy;

import org.example.small_project.hyeeun.Policy;
import org.example.small_project.ljy.Passenger;
import org.example.small_project.parkjunhyeon.domain.Vehicle;

public class BoardingService {
    public void board(Passenger p, Vehicle v) {
        Policy.getInstance().setPolicy(p);
        if (v.canBoard()) {
            if(!v.getIn(p)){
                System.out.println("탑승 불가: 잔액 부족");
            }
        } else {
            System.out.println("탑승 불가: 인원 초과");
        }
    }
}