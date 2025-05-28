package org.example.small_project.hyeeun;

import org.example.small_project.ljy.Passenger;

public class Policy {
    private static Policy instance = new Policy();

    private int maxBabyAge = 9;
    private int maxStudentAge = 29;
    private int minSeniorAge = 59;
    private double babyDiscount = 0.9;
    private double studentDiscount = 0.1;
    private double seniorDiscount = 0.3;

    private Policy() {}

    public static Policy getInstance() {
        return instance;
    }

    public void setPolicy(Passenger p) {
        int age = p.getAge();
        if (age <= maxBabyAge) p.setType("BABY");
        else if (age <= maxStudentAge) p.setType("STUDENT");
        else if (age > minSeniorAge) p.setType("SENIOR");
        else p.setType("ORDINARY");
    }

    public double getDiscountRate(String type) {
        return switch (type) {
            case "BABY" -> babyDiscount;
            case "STUDENT" -> studentDiscount;
            case "SENIOR" -> seniorDiscount;
            default -> 0.0;
        };
    }
}
