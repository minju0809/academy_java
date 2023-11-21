package DBPKG.money;

import java.util.List;

public interface MoneyService {
	List<MoneyVO> getMoney(String sort);

	void insert(MoneyVO moneyVO);

	int maxSalenol();

	List<MoneyVO> getMoneySdate();
}
