
package DBPKG.money;

import java.util.List;

public class MoneyServiceImpl implements MoneyService {

	MoneyDao moneyDao = new MoneyDaoImpl();
	
	@Override
	public List<MoneyVO> getMoney(String s) {
		return moneyDao.getMoney(s);
	}

	@Override
	public int maxSalenol() {
		return moneyDao.maxSalenol();
	}

	@Override
	public void insert(MoneyVO moneyVO) {
		moneyDao.insert(moneyVO);
	}

	@Override
	public List<MoneyVO> getMoneySdate() {
		return moneyDao.getMoneySdate();
	}

}
