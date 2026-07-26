package pro.netech.testmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import pro.netech.testmanagement.entity.TestCase;
import pro.netech.testmanagement.enums.Priority;
import pro.netech.testmanagement.enums.TestStatus;
import pro.netech.testmanagement.service.TestCaseService;

@RestController
public class TestCaseController {

	private final TestCaseService testCaseService;

	public TestCaseController(TestCaseService testCaseService) {
		this.testCaseService = testCaseService;
	}

	@GetMapping("/testcases")
	public List<TestCase> getAllTestCases() {
		return testCaseService.getAllTestCases();
	}

	@PostMapping("/testcases")
	public TestCase createTestCase() {

		TestCase testCase = new TestCase(null, "Verify successful login", "Verify that a valid user can log in",
				Priority.HIGH, TestStatus.READY, true);

		return testCaseService.save(testCase);

	}

}