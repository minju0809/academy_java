package ch01;

import java.util.ArrayList;
import java.util.List;

public class GuguDanImpl implements GuguDan {

	@Override
	public List<GugudanVO> gugudan() {
		List<GugudanVO> li = new ArrayList<GugudanVO>();
		GugudanVO m = null;
		for(int dan = 2; dan <= 9; dan++) {
			for (int i = 1; i <=9; i++) {
				m= new GugudanVO();
				m.setDan(dan);
				m.setI(i);
				m.setGugu(dan*i);
				li.add(m);
			}
		}
		return li;
	}
	
}
