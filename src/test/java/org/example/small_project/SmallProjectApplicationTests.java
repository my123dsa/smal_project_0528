package org.example.small_project;

import org.example.small_project.hyeeun.Policy;
import org.example.small_project.jhy.BoardingService;
import org.example.small_project.ljy.Passenger;
import org.example.small_project.parkjunhyeon.domain.Bus;
import org.example.small_project.parkjunhyeon.domain.Subway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class SmallProjectApplicationTests {

    private Bus bus;
    private Subway subway;
    private BoardingService boardingService;

    @BeforeAll
     void setUp() {
        bus = new Bus("Bus-01", 50, 1000);
        subway = new Subway("Sub=01", 1000, 1500);
        boardingService = new BoardingService();
    }

    // Board success
    @Test
    void testPassengerBoardsBusSuccessfully() {
        // Given
        Passenger p = new Passenger("s1", 5000, 20150909);
        Policy.getInstance().setPolicy(p);
        int beforeCash = p.getCash();

        // When
        boardingService.board(p, bus);

        // Then
        assertEquals("탑승", p.getState());
        assertEquals(1, bus.getPassengers());
        assertTrue(p.getCash() < beforeCash);
        assertEquals((int)(1000 * (1 - 0.1)), bus.getRevenue()); // 청소년 10% 할인
    }


    // Board failed: less money
    @Test
    void testPassengerBoardsBusFailed() {
        // Given
        Passenger p = new Passenger("s2", 0, 20150909);
        Policy.getInstance().setPolicy(p);
        int beforeCash = p.getCash();

        // When
        boardingService.board(p, bus);

        // Then
        assertEquals(null, p.getState());
        assertEquals(0, bus.getPassengers());
        assertTrue(p.getCash() == beforeCash);
        assertEquals(0, bus.getRevenue()); 
    }


    // Baby discount
    @Test
    void testBabyDiscount() {
        // 수정
        Passenger baby = new Passenger("baby", 5000, 20240428); // baby
        Policy.getInstance().setPolicy(baby);
        int before = baby.getCash();

        boardingService.board(baby, bus);

        int expectedFare = (int) (1000 * (1 - 0.75)); // 75% 할인
        System.out.println(expectedFare);
        assertEquals("탑승", baby.getState());
        assertEquals(before - expectedFare, baby.getCash());
        assertEquals(expectedFare, bus.getRevenue());
    }


    // Test senior discount
    @Test
    void testSeniorDiscount() {
        // 수정
        Passenger senior = new Passenger("senior", 10000, 19500428); // baby
        Policy.getInstance().setPolicy(senior);
        int before = senior.getCash();

        boardingService.board(senior, bus);

        int expectedFare = (int) (1000 * (1 - 0.25)); // 25% 할인
        System.out.println(expectedFare);
        assertEquals("탑승", senior.getState());
        assertEquals(before - expectedFare, senior.getCash());
        assertEquals(expectedFare, bus.getRevenue());
    }

    // Max passenger
    @Test
    void testPassengerCannotBoard() {
        // Given
        Bus smallBus = new Bus("B-102", 0, 1000); // 최대인원 0
        Passenger p = new Passenger("o1", 5000, 19900101);

        // When
        boardingService.board(p, smallBus);

        // Then
        assertEquals(null, p.getState());
        assertEquals(0, smallBus.getPassengers());
        assertEquals(5000, p.getCash()); // 돈 안 빠짐
    }

    @Test
    void contextLoads() {
    }
}
