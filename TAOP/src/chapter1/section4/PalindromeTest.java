package chapter1.section4;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void test() {
		assertTrue(Palindrome.isPalindrome("madam"));
		assertFalse(Palindrome.isPalindrome("mada"));
		assertFalse(Palindrome.isPalindrome(null));
	}

}
