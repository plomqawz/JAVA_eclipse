package singleton;

public class CompanyTest {

	public static void main(String[] args) {

		Company myCompany1 = Company.getInstance();
		Company myCompany2 = Company.getInstance();
		System.out.println("myCompany1 의 참조값 주소 : " + myCompany1);
		System.out.println("myCompany2 의 참조값 주소 : " + myCompany2);
		// 하나의 같은 인스턴스이기 때문에 1이든 2든 같다.
		System.out.println( myCompany1 == myCompany2 );
		myCompany1.address = "부산";
		myCompany1.name = "일하영";
		myCompany1.age = 27;
		System.out.println("myCompany1 address : " + myCompany1.address);
		System.out.println("myCompany1 name : " + myCompany1.name);
		System.out.println("myCompany1 age : " + myCompany1.age);
	}
}
