package com.iiht.evaluation.yaksha.string;

import static com.iiht.evaluation.yaksha.testutils.TestUtils.boundaryTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.exceptionTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.testReport;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CountStringCharacterTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCountDiffStringChar() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		String input = "Test,String 12!";
		int[] array = obj.countDiffStringCharTypes(input);
		if (array == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), array.length == 14 ? "true" : "false", businessTestFile);
	}

	@Test
	public void testCountStringUpparAlphabets() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		String input = "Test,String12!";
		int[] charCountArray = obj.countDiffStringCharTypes(input);
		if (charCountArray == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), charCountArray[0] == 2 ? "true" : "false", businessTestFile);
	}

	@Test
	public void testCountStringLowerAlphabets() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		String input = "Test,String 12!";
		int[] charCountArray = obj.countDiffStringCharTypes(input);
		if (charCountArray == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), charCountArray[1] == 8 ? "true" : "false", businessTestFile);
	}

	@Test
	public void testCountStringDigitChar() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		String input = "Test,String 12!";
		int[] charCountArray = obj.countDiffStringCharTypes(input);
		if (charCountArray == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), charCountArray[2] == 2 ? "true" : "false", businessTestFile);
	}

	@Test
	public void testCountStringSpecialChar() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		String input = "Test,String 12!";
		int[] charCountArray = obj.countDiffStringCharTypes(input);
		if (charCountArray == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), charCountArray[3] == 2 ? "true" : "false", businessTestFile);
	}

	@Test
	public void testCountStringCharForEmptyString() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		String input = "";
		int[] charCountArray = obj.countDiffStringCharTypes(input);
		if (charCountArray == null) {
			yakshaAssert(currentTest(), "false", boundaryTestFile);
			return;
		}
		yakshaAssert(currentTest(), charCountArray.length == 0 ? "true" : "false", boundaryTestFile);
	}

	@Test
	public void testCountStringCharForNullString() throws Exception {
		CountStringCharacter obj = new CountStringCharacter();
		int[] charCountArray = null;
		try {
			String input = null;
			charCountArray = obj.countDiffStringCharTypes(input);
		} catch (NullPointerException e) {
			yakshaAssert(currentTest(), "false", exceptionTestFile);
			return ;
		}
		yakshaAssert(currentTest(), "false", exceptionTestFile);
	}

}
