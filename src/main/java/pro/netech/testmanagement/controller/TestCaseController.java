package pro.netech.testmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pro.netech.testmanagement.entity.TestCase;
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
	public TestCase createTestCase(@Valid @RequestBody TestCase testCase) {
		return testCaseService.save(testCase);
	}

	@GetMapping("/testcases/{id}")
	public TestCase getTestCaseById(@PathVariable Long id) {

		return testCaseService.getTestCaseById(id);

	}

	@PutMapping("/testcases/{id}")
	public TestCase updateTestCase(@PathVariable Long id, @Valid @RequestBody TestCase testCase) {

		return testCaseService.updateTestCase(id, testCase);
	}

	@DeleteMapping("/testcases/{id}")
	public void deleteTestCase(@PathVariable Long id) {
		testCaseService.deleteTestCase(id);
	}

}