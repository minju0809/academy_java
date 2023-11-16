package DBPKG;

import java.util.List;

public interface MoneyService {
	List<MoneyVO> money(String order);
	
	int salenol();
	
	void moneyInsert(MoneyVO vo);
	
	List<MoneyVO> moneySelect(MoneyVO vo);
	
	List<MoneyVO> dayMoneySelect(MoneyVO vo);
	
	List<Integer> getMoneySelectCustno();
}
