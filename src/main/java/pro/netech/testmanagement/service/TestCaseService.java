package pro.netech.testmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pro.netech.testmanagement.entity.TestCase;
import pro.netech.testmanagement.repository.TestCaseRepository;

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

}