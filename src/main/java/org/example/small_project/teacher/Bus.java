package basic_ex01;

public class Bus {
	private int busNumber = 0;
	private int money = 0;
	private int passengerCount = 0;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
		this.money=0;
		this.passengerCount = 0;
	}
	
	public void getIn(Passenger mem) {
		++this.passengerCount;
		this.money += 1000;
		mem.withdraw(1000);
		
		System.out.println("버스승차");
		
	}
	
	public void getIn(Student mem) {
		++this.passengerCount;
		this.money =+ 900;
		mem.withdraw(900);
		
		System.out.println("학생 버스 승차");
		
	}
	
	public void getOut() {
		--this.passengerCount;
		System.out.println("버스하차");
	}
	
	public void getOut(Passenger mem) {
		this.getOut();
		System.out.println("버스하차");
		mem.showInfo();
	}
	
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("버스 번호" + this.busNumber + "의 탑승고객 수는 " + this.passengerCount + "명, 수익금은" + this.money+"원 입니다.");
	}
}
