package components;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import components.TimedString;

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
	public void CombineTest() {		
		TimedString appended = ts1.combine(ts2);
		System.out.println(ts1);
		assertEquals("abc def", appended.getImplodedString());
		assertEquals(Long.valueOf(1500), appended.getPositionMap().get(1));
		assertEquals(Long.valueOf(1600), appended.getPositionMap().get(2));
		assertEquals(Long.valueOf(1700), appended.getPositionMap().get(3));
		assertEquals(Long.valueOf(1700), appended.getPositionMap().get(4));
		assertEquals(Long.valueOf(2400), appended.getPositionMap().get(5));
		assertEquals(Long.valueOf(2500), appended.getPositionMap().get(6));
		assertEquals(Long.valueOf(2600), appended.getPositionMap().get(7));
	}
	
	@Test
	public void CombineTest_IdentityLastCase() {		
		TimedString appended = ts1.combine(TimedString.Identity());
		assertEquals("abc", appended.getImplodedString());
		assertEquals(Long.valueOf(1500), appended.getPositionMap().get(1));
		assertEquals(Long.valueOf(1600), appended.getPositionMap().get(2));
		assertEquals(Long.valueOf(1700), appended.getPositionMap().get(3));
	}
	
	@Test
	public void CombineTest_IdentityFirstCase() {		
		TimedString appended = TimedString.Identity().combine(ts1);
		assertEquals("abc", appended.getImplodedString());
		assertEquals(Long.valueOf(1500), appended.getPositionMap().get(1));
		assertEquals(Long.valueOf(1600), appended.getPositionMap().get(2));
		assertEquals(Long.valueOf(1700), appended.getPositionMap().get(3));
	}
	
	@Test
	public void CombineTest_ReverseCase(){
		fail();
	}
	
	@Test
	public void CombineTest_BetweenCase(){
		fail();
	}
	
	
	@Test
	public void CopyTest(){
		TimedString copied = ts1.copy();
		assertFalse(ts1 == copied);
		assertFalse(ts1.getImplodedString() == copied.getImplodedString());
		assertFalse(ts1.getPositionMap() == copied.getPositionMap());
		
		assertEquals("abc", copied.getImplodedString());
		assertEquals(Long.valueOf(1500), copied.getPositionMap().get(1));
		assertEquals(Long.valueOf(1600), copied.getPositionMap().get(2));
		assertEquals(Long.valueOf(1700), copied.getPositionMap().get(3));
	}
	
	@Test
	public void IdentityTest(){
		assertTrue(TimedString.Identity().getImplodedString().isEmpty());
		assertTrue(TimedString.Identity().getPositionMap().isEmpty());
	}

}
