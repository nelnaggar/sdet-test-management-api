package pro.netech.testmanagement.testcase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pro.netech.testmanagement.testcase.dto.TestCaseRequest;
import pro.netech.testmanagement.testcase.dto.TestCaseResponse;
import pro.netech.testmanagement.testcase.entity.TestCase;
import pro.netech.testmanagement.testcase.exception.TestCaseNotFoundException;
import pro.netech.testmanagement.testcase.mapper.TestCaseMapper;
import pro.netech.testmanagement.testcase.repository.TestCaseRepository;

@Service
public class TestCaseService {

    private final TestCaseRepository repository;
    private final TestCaseMapper mapper;

    public TestCaseService(
            TestCaseRepository repository,
            TestCaseMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TestCaseResponse> getAllTestCases() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public TestCaseResponse getTestCaseById(Long id) {
        TestCase testCase = findEntityById(id);
        return mapper.toResponse(testCase);
    }

    public TestCaseResponse createTestCase(TestCaseRequest request) {
        TestCase testCase = mapper.toEntity(request);
        TestCase savedTestCase = repository.save(testCase);

        return mapper.toResponse(savedTestCase);
    }

    public TestCaseResponse updateTestCase(
            Long id,
            TestCaseRequest request) {

        TestCase existingTestCase = findEntityById(id);

        mapper.updateEntity(request, existingTestCase);

        TestCase updatedTestCase = repository.save(existingTestCase);

        return mapper.toResponse(updatedTestCase);
    }

    public void deleteTestCase(Long id) {
        TestCase existingTestCase = findEntityById(id);
        repository.delete(existingTestCase);
    }

    private TestCase findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TestCaseNotFoundException(id));
    }
}