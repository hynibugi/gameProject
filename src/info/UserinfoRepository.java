package info;

public interface UserinfoRepository {
	
	int countByID(String inputId);
	int countByNickName(String inputNickname);
	int insert(String inputId, String inputPassword, String inputNickname);
	int lastNo();
	int standardCharacter(int lastNo);
	int login(String inputId, String inputPassword);
	int setMoney(int myNo);
	int countMoney(String inputId);
	int changeMoney(String inputId, int price);
	int buyCharacter(String inputId, int whatCharacter);
	int haveCharacter(int lastNo, int whatCharacter);
	int getMyNo(String inputId);
	int choiceCharacte(int myNo, int whatCharacter);
	int findCharacte(String inputId);
	
	int findLastRound(int myNo);
	int stadardRound(int lastNo);
	int saveScore(int myNo, int lastRound, int score, int money, int myCharacter);
	int getMyCharacter(String inputId);
	
}
