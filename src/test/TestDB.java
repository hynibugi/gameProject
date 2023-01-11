package test;

import info.UserinfoRepository;
import info.UserinfoRepositoryImpl;

public class TestDB {
	public static void main(String[] args) {
		UserinfoRepository repo = new UserinfoRepositoryImpl();
//		int money = repo.countMoney("test1");
//		System.out.println(money);
		
//		int buyResult = repo.buyCharacter(35, 3, 3000);
//		System.out.println(buyResult);
		
//		int have = repo.haveCharacter(35, 3);
//		System.out.println(have);
		
		
//		int myNo = repo.getMyNo("test1");
//		System.out.println(myNo);
		
//		int result = repo.changeMoney("test1", 2000);
//		System.out.println(result);
		
//		int result = repo.findCharacte("asdf");
//		System.out.println(result);
		
		
//		int result = repo.findLastRound(2);
//		System.out.println(result);
		
//		int result = repo.choiceCharacte(53, 2);
//		System.out.println(result);
		
		int result = repo.setMoney(53);
		System.out.println(result);
		
	}
}
