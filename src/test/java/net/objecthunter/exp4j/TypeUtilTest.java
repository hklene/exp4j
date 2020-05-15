package net.objecthunter.exp4j;

import static org.junit.Assert.*;

import org.junit.Test;

public class TypeUtilTest {

	@Test
	public void testParseConstantHexValues() {
		assertEquals("", 2147483648L, TypeUtil.parseConstant("0x80000000"));
	}

}
