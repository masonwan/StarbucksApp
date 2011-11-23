package tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import widgets.*;

public class KeyPadTest {

	public KeyPadTest() {

	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void TestKey1() {
		KeyPad keyPad = new KeyPad();
		assertEquals('1', keyPad.press(1, 1));
	}

	@Test
	public void TestKey2() {
		KeyPad keyPad = new KeyPad();
		assertEquals('2', keyPad.press(2, 1));
	}

	@Test
	public void TestKey3() {
		KeyPad keyPad = new KeyPad();
		assertEquals('3', keyPad.press(3, 1));
	}

	@Test
	public void TestKey4() {
		KeyPad keyPad = new KeyPad();
		assertEquals('4', keyPad.press(1, 2));
	}

	@Test
	public void TestKey5() {
		KeyPad keyPad = new KeyPad();
		assertEquals('5', keyPad.press(2, 2));
	}

	@Test
	public void TestKey6() {
		KeyPad keyPad = new KeyPad();
		assertEquals('6', keyPad.press(3, 2));
	}

	@Test
	public void TestKey7() {
		KeyPad keyPad = new KeyPad();
		assertEquals('7', keyPad.press(1, 3));
	}

	@Test
	public void TestKey8() {
		KeyPad keyPad = new KeyPad();
		assertEquals('8', keyPad.press(2, 3));
	}

	@Test
	public void TestKey9() {
		KeyPad keyPad = new KeyPad();
		assertEquals('9', keyPad.press(3, 3));
	}

	@Test
	public void TestKey0() {
		KeyPad keyPad = new KeyPad();
		assertEquals('0', keyPad.press(2, 4));
	}

	@Test
	public void TestKeyX() {
		KeyPad keyPad = new KeyPad();
		assertEquals('X', keyPad.press(3, 4));
	}

	@Test
	public void TestKeyBlank() {
		KeyPad keyPad = new KeyPad();
		assertEquals(' ', keyPad.press(1, 4));
	}
}
