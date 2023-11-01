package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SuppressWarnings("unchecked")
public class BoardMapImpl implements BoardMap {
//	Map map = new HashMap();
	MapVo1 m1 = new MapVo1();
	List<MapVo2> li = new ArrayList();

	@Override
	public MapVo1 insert() {
		m1.setCode(100);
		m1.setMsg("성공");
		m1.setMethod("insert");
//		System.out.println(m1);
		return m1;
	}

	MapVo2 m2 = null;
	public List<MapVo2> login() {
		m2 = new MapVo2();
		m2.setId("ppk");
		m2.setPwd("1234");
		li.add(m2);
		
		m2 = new MapVo2();
		m2.setId("kang");
		m2.setPwd("1111");
		li.add(m2);
		
		m2 = new MapVo2();
		m2.setId("kim");
		m2.setPwd("1212");
		li.add(m2);
		
		m2 = new MapVo2();
		m2.setId("park");
		m2.setPwd("2222");
		li.add(m2);

		return li;
	}

//	@Override
//	public Map<String, Object> insert() {
//		map.put("code", 100);
//		map.put("msg", "성공");
//		map.put("method", "insert");
//		return map;
//	}

//	@Override
//	public Map<String, String> login() {
//		map.put("ppk", "1234");
//		map.put("kang", "1111");
//		map.put("kim", "1212");
//		map.put("park", "2222");
//		return map;
//	}
}
