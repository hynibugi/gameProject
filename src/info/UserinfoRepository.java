package info;

public interface UserinfoRepository {
	
	int countByID(String inputId);
	int countByNickName(String inputNickname);
	int insert(String inputId, String inputPassword, String inputNickname);
	
	int login(String inputId, String inputPassword);
	
	int countMoney(String inputId);
}
