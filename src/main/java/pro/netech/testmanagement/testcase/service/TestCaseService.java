package pro.netech.testmanagement.testcase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pro.netech.testmanagement.testcase.entity.TestCase;
import pro.netech.testmanagement.testcase.exception.TestCaseNotFoundException;
import pro.netech.testmanagement.testcase.repository.TestCaseRepository;

@Service
public class TestCaseService {

	private final TestCaseRepository repository;

	public TestCaseService(TestCaseRepository repository) {
		this.repository = repository;
	}

	public List<TestCase> getAllTestCases() {
		return repository.findAll();
	}

	public TestCase save(TestCase testCase) {

		return repository.save(testCase);

	}

	public TestCase getTestCaseById(Long id) {
		return repository.findById(id).orElseThrow(() -> new TestCaseNotFoundException(id));
	}

	public TestCase updateTestCase(Long id, TestCase updatedTestCase) {
		TestCase existingTestCase = getTestCaseById(id);

		existingTestCase.setTitle(updatedTestCase.getTitle());
		existingTestCase.setDescription(updatedTestCase.getDescription());
		existingTestCase.setPriority(updatedTestCase.getPriority());
		existingTestCase.setStatus(updatedTestCase.getStatus());
		existingTestCase.setAutomated(updatedTestCase.getAutomated());

		return repository.save(existingTestCase);
	}

	public void deleteTestCase(Long id) {
		TestCase existingTestCase = getTestCaseById(id);
		repository.delete(existingTestCase);
	}

}