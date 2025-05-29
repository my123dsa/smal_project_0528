package basic_ex01;

public class Student implements Passenger {
	private int money = 0;
	private int studentNo = 0;
	private static int gsid = 0;
	
	public Student(int money) {
		this.money = money;
		this.studentNo = ++gsid;
	}

	@Override
	public void withdraw(int amount) {
		this.money -= amount;
	}
	
	public void deposit(int amount) {
		this.money += amount;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("학생번호" + this.studentNo + "의 소지금은" + this.money+"원 입니다.");
	}

}
