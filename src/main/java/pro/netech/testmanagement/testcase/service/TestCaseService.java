
package pro.netech.testmanagement.testcase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pro.netech.testmanagement.testcase.dto.TestCaseRequest;
import pro.netech.testmanagement.testcase.dto.TestCaseResponse;
import pro.netech.testmanagement.testcase.entity.TestCase;
import pro.netech.testmanagement.testcase.exception.TestCaseNotFoundException;
import pro.netech.testmanagement.testcase.mapper.TestCaseMapper;
import pro.netech.testmanagement.testcase.repository.TestCaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TestCaseService {

	private static final Logger logger = LoggerFactory.getLogger(TestCaseService.class);

	private final TestCaseRepository repository;
	private final TestCaseMapper mapper;

	public TestCaseService(TestCaseRepository repository, TestCaseMapper mapper) {

		this.repository = repository;
		this.mapper = mapper;
	}

	public List<TestCaseResponse> getAllTestCases() {

		logger.info("Retrieving all test cases");

		List<TestCaseResponse> responses = repository.findAll().stream().map(mapper::toResponse).toList();

		logger.info("Retrieved {} test cases", responses.size());

		return responses;
	}

	public TestCaseResponse getTestCaseById(Long id) {

		logger.info("Retrieving test case with id {}", id);

		TestCase testCase = findEntityById(id);

		logger.info("Test case with id {} retrieved successfully", id);

		return mapper.toResponse(testCase);
	}

	public TestCaseResponse createTestCase(TestCaseRequest request) {

		logger.info("Creating test case with title '{}'", request.getTitle());

		TestCase testCase = mapper.toEntity(request);
		TestCase savedTestCase = repository.save(testCase);

		logger.info("Test case created successfully with id {} and title '{}'", savedTestCase.getId(),
				savedTestCase.getTitle());

		return mapper.toResponse(savedTestCase);
	}

	public TestCaseResponse updateTestCase(Long id, TestCaseRequest request) {

		logger.info("Updating test case with id {}", id);

		TestCase existingTestCase = findEntityById(id);

		mapper.updateEntity(existingTestCase, request);

		TestCase updatedTestCase = repository.save(existingTestCase);

		logger.info("Test case with id {} updated successfully", id);

		return mapper.toResponse(updatedTestCase);
	}

	public void deleteTestCase(Long id) {

		logger.info("Deleting test case with id {}", id);

		TestCase testCase = findEntityById(id);

		repository.delete(testCase);

		logger.info("Test case with id {} deleted successfully", id);
	}

	private TestCase findEntityById(Long id) {

		return repository.findById(id).orElseThrow(() -> {
			logger.warn("Test case with id {} was not found", id);
			return new TestCaseNotFoundException(id);
		});
	}
}