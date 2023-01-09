package info;

public interface UserinfoRepository {
	
	int countByID(String inputId);
	int countByNickName(String inputNickname);
	int insert(String inputId, String inputPassword, String inputNickname);
	int lastNo();
	int standardCharacter(int lastNo);
	
	int login(String inputId, String inputPassword);
	int countMoney(String inputId);
	int changeMoney(String inputId, int price);
	int buyCharacter(String inputId, int whatCharacter);
	int haveCharacter(int lastNo, int whatCharacter);
	int getMyNo(String inputId);
}
