package DBPKG;

import java.util.List;

public class MoneyServiceImpl implements MoneyService {
	MoneyDao dao = null;
	
	public MoneyServiceImpl() {
		dao = new MoneyDaoImpl();
	}


	@Override
	public List<MoneyVO> money(String order) {
		return dao.money(order);
	}

	@Override
	public int salenol() {
		return dao.salenol();
	}

	@Override
	public void moneyInsert(MoneyVO vo) {
		dao.moneyInsert(vo);
	}

	@Override
	public List<MoneyVO> moneySelect(MoneyVO vo) {
		return dao.moneySelect(vo);
	}
	
	@Override
	public List<MoneyVO> dayMoneySelect(MoneyVO vo) {
		return dao.dayMoneySelect(vo);
	}

	@Override
	public List<Integer> getMoneySelectCustno() {
		return dao.getMoneySelectCustno();
	}


}
