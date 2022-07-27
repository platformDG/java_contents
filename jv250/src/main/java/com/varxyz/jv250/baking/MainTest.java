package com.varxyz.jv250.baking;

public class MainTest {
	public static void main(String[] args) {
		//임의의 고객객체 3개를 생성한다.
		Customer c1 = new Customer("박동근","880321-1688875", "010-6686-8564", "A001", "1234");
		Customer c2 = new Customer("유재석","730505-1125744", "010-7454-6275", "A002", "1234");
		Customer c3 = new Customer("서현진","830210-2111711", "010-5555-5425", "A003", "1234");
		
		CustomerService cs = CustomerServiceImpl.getInstance();
		AccountService as = AccountServiceImpl.getInstance();
		
		/**
		 * 3명의 고객한테 계좌를 생성한다.
		 * 계좌를 컨트롤 할 수 있는 AccountServiceImpl 클래스를 객체를 생성하여서 
		 * AccountServiceImpl의 메소드를 활용하여 계좌개설을 한다.
		 * 차별성을 위해 고객객체 c1은 계좌를 두가지로 생성한다.
		 */
		c1.setAccount(as.createSavingAccount("계좌번호1", 5000.0));
		c2.setAccount(as.createSavingAccount("계좌번호2", 3000.0));
		c3.setAccount(as.createCheckingAccount("계좌번호3", 5000.0, 20000.0));
		c1.setAccount(as.createCheckingAccount("졔좌번호4", 5000.0, 20000.0));
		
		/**
		 * 계좌정보까지 가진 고객정보를 고객정보를 컨트롤 할 수 있는 
		 * CustomerServiceImpl 클래스 객체에 고객 객체를 추가한다.
		 */
		cs.addCustomer(c1);
		cs.addCustomer(c2);
		cs.addCustomer(c3);
		
		/**
		 * 계좌정보를 컨트롤 할 수 있는 AccountServiceImpl 클래스에 고객 계좌를 추가한다.
		 * 고민해볼것 : CustomerServiceImpl 클래스에서 고객정보의 계좌를 리턴해서 추가해줘야 하는거 아닌가 ?  
		 */
		as.addAccount(c1.getAccount().get(0));
		as.addAccount(c2.getAccount().get(0));
		as.addAccount(c3.getAccount().get(0));
		as.addAccount(c1.getAccount().get(1));
		
		/**
		 * 계좌정보를 컨트롤 할 수 있는 AccountServiceImpl 클래스에 고객 계좌 주민번호를 매칭해서 추가한다.
		 * 고민해볼것 : 위의 정보와 같이 CustomerServiceImpl 클래스에서 고객정보의 계좌를 리턴해서 추가해줘야 하는거 아닌가 ?  
		 */
		as.addAccount(c1.getAccount().get(0), c1.getSsn());
		as.addAccount(c2.getAccount().get(0), c2.getSsn());
		as.addAccount(c3.getAccount().get(0), c3.getSsn());
		as.addAccount(c1.getAccount().get(1), c1.getSsn());

		System.out.println("전체고객의 명단 : ");		
		for(Customer c : cs.getAllCustomer() ) {
			System.out.println(c.getName());
		}
		System.out.println("\n주민번호로 검색결과 : " + as.getAccountBySsn("880321-1688875").get(1).getAccountNum());
		System.out.println("\n계좌번호로 검색결과 : " + as.getAccountByAccountNum("계좌번호1").getAccountNum());
	}
}
