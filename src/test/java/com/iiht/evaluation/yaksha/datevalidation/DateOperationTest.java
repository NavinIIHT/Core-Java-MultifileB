package com.iiht.evaluation.yaksha.datevalidation;

import static com.iiht.evaluation.yaksha.testutils.TestUtils.boundaryTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.exceptionTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.testReport;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.yakshaAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class DateOperationTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testDateMonthValidationValidMonth() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "07/12/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		Boolean isMonthValid = dateOperation.dateMonthValidation(date);
		if (isMonthValid == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), isMonthValid ? "true" : "false", businessTestFile);
	}

	@Test
	public void testDateMonthValidationInvalidMonth() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "07/13/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		Boolean isMonthValid = dateOperation.dateMonthValidation(date);
		if (isMonthValid == null) {
			yakshaAssert(currentTest(), "false", exceptionTestFile);
			return;
		}
		yakshaAssert(currentTest(), isMonthValid, exceptionTestFile);
	}

	@Test
	public void testGetWeekDay() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "07/12/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		String weekDays = dateOperation.getWeekDay(date);
		if (weekDays == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), !weekDays.isEmpty() ? "true" : "false", businessTestFile);
	}

	@Test
	public void testGetWeekDayValid() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "07/12/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		String weekDays = dateOperation.getWeekDay(date);
		if (weekDays == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), weekDays.equals("TUE") ? "true" : "false", businessTestFile);
	}

	@Test
	public void testGetWeekDayNoWeekDays() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "10/09/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		String weekDays = dateOperation.getWeekDay(date);
		if (weekDays == null) {
			yakshaAssert(currentTest(), "false", boundaryTestFile);
			return;
		}
		yakshaAssert(currentTest(), weekDays.isEmpty() ? "true" : "false", boundaryTestFile);
	}

	@Test
	public void testIsValidDayTrue() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "26/02/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		Boolean isDayValid = dateOperation.isValidDay(date);
		if (isDayValid == null) {
			yakshaAssert(currentTest(), "false", businessTestFile);
			return;
		}
		yakshaAssert(currentTest(), isDayValid ? "true" : "false", businessTestFile);
	}

	@Test
	public void testIsValidDayFalse() throws Exception {
		DateOperation dateOperation = new DateOperation();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "30/02/2021";
		//LocalDate inputDate = LocalDate.parse(date, formatter);
		Boolean isDayValid = dateOperation.isValidDay(date);
		if (isDayValid == null) {
			yakshaAssert(currentTest(), "false", exceptionTestFile);
			return;
		}
		yakshaAssert(currentTest(), !isDayValid?"true" : "false" , exceptionTestFile);
	}

}
