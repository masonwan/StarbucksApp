package tests;

import static org.junit.Assert.*;

import org.junit.*;

import widgets.*;

public class KeyPadTest {

	private KeyPad keyPad = new KeyPad();

	@Test
	public void TestKey1() {
		assertEquals('1', keyPad.press(1, 1));
	}

	@Test
	public void TestKey2() {
		assertEquals('2', keyPad.press(2, 1));
	}

	@Test
	public void TestKey3() {
		assertEquals('3', keyPad.press(3, 1));
	}

	@Test
	public void TestKey4() {
		assertEquals('4', keyPad.press(1, 2));
	}

	@Test
	public void TestKey5() {
		assertEquals('5', keyPad.press(2, 2));
	}

	@Test
	public void TestKey6() {
		assertEquals('6', keyPad.press(3, 2));
	}

	@Test
	public void TestKey7() {
		assertEquals('7', keyPad.press(1, 3));
	}

	@Test
	public void TestKey8() {
		assertEquals('8', keyPad.press(2, 3));
	}

	@Test
	public void TestKey9() {
		assertEquals('9', keyPad.press(3, 3));
	}

	@Test
	public void TestKey0() {
		assertEquals('0', keyPad.press(2, 4));
	}

	@Test
	public void TestKeyX() {
		assertEquals('X', keyPad.press(3, 4));
	}

	@Test
	public void TestKeyBlank() {
		assertEquals(' ', keyPad.press(1, 4));
	}
}
