package test;

import info.UserinfoRepository;
import info.UserinfoRepositoryImpl;

public class TestDB {
	public static void main(String[] args) {
		UserinfoRepository repo = new UserinfoRepositoryImpl();
		int money = repo.countMoney("test1");
		System.out.println(money);
	}
}
