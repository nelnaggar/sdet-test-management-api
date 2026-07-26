package pro.netech.testmanagement.testcase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pro.netech.testmanagement.testcase.entity.TestCase;
import pro.netech.testmanagement.testcase.service.TestCaseService;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Tag(name = "Test Case Management", description = "Operations for creating, retrieving, updating and deleting software test cases.")
public class TestCaseController {

	private final TestCaseService testCaseService;

	public TestCaseController(TestCaseService testCaseService) {
		this.testCaseService = testCaseService;
	}

	@Operation(summary = "Retrieve all test cases", description = "Returns all available test cases stored in the database.")
	@GetMapping("/testcases")
	public List<TestCase> getAllTestCases() {
		return testCaseService.getAllTestCases();
	}

	@Operation(summary = "Create a new test case", description = "Creates a new software test case.")
	@PostMapping("/testcases")
	public TestCase createTestCase(@Valid @RequestBody TestCase testCase) {
		return testCaseService.save(testCase);
	}

	@Operation(summary = "Retrieve a test case by ID", description = "Returns a single test case using its unique identifier.")
	@GetMapping("/testcases/{id}")
	public TestCase getTestCaseById(@PathVariable Long id) {

		return testCaseService.getTestCaseById(id);

	}

	@Operation(summary = "Update an existing test case", description = "Updates an existing software test case.")
	@PutMapping("/testcases/{id}")
	public TestCase updateTestCase(@PathVariable Long id, @Valid @RequestBody TestCase testCase) {

		return testCaseService.updateTestCase(id, testCase);
	}

	@Operation(summary = "Delete a test case", description = "Deletes a software test case using its unique identifier.")
	@DeleteMapping("/testcases/{id}")
	public void deleteTestCase(@PathVariable Long id) {
		testCaseService.deleteTestCase(id);
	}

}