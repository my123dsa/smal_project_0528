package basic_ex01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stud1 = new Student(10000);
		stud1.showInfo();
		
		Student stud2 = new Student(20000);
		stud2.showInfo();
		
		Bus bus100 = new Bus(100);
		bus100.showInfo();
		
		Bus bus200 = new Bus(200);
		bus200.showInfo();
		
		bus100.getIn(stud1);
		bus100.getIn(stud2);
		
		bus100.getOut(stud1);
	}

}
