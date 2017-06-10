package matchingtests;

import static org.junit.Assert.assertEquals;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import matching.TimedString;

public class TimedStringTests {
	
	private TimedString ts1, ts2;
	
	@Before
	public void setUp(){
		String s1 = "abc";
		TreeMap<Integer, Long> pm1 = new TreeMap<Integer, Long>();
		pm1.put(1, 1500L);
		pm1.put(2, 1600L);
		pm1.put(3, 1700L);
		ts1 = new TimedString(pm1, s1);
		
		String s2 = "def";
		TreeMap<Integer, Long> pm2 = new TreeMap<Integer, Long>();
		pm2.put(1, 2400L);
		pm2.put(2, 2500L);
		pm2.put(3, 2600L);
		ts2 = new TimedString(pm2, s2);
	}
	
	@Test
	public void LengthTest(){
		assertEquals(3, ts1.length());
	}

	@Test
	public void AppendTest() {		
		ts1.append(ts2);
		System.out.println(ts1);
		assertEquals("abc def", ts1.getImplodedString());
		assertEquals(Long.valueOf(1500), ts1.getPositionMap().get(1));
		assertEquals(Long.valueOf(1600), ts1.getPositionMap().get(2));
		assertEquals(Long.valueOf(1700), ts1.getPositionMap().get(3));
		assertEquals(Long.valueOf(1700), ts1.getPositionMap().get(4));
		assertEquals(Long.valueOf(2400), ts1.getPositionMap().get(5));
		assertEquals(Long.valueOf(2500), ts1.getPositionMap().get(6));
		assertEquals(Long.valueOf(2600), ts1.getPositionMap().get(7));


	}

}
