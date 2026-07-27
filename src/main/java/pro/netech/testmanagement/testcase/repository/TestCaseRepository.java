package pro.netech.testmanagement.testcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import pro.netech.testmanagement.testcase.entity.TestCase;

public interface TestCaseRepository
        extends JpaRepository<TestCase, Long>,
                JpaSpecificationExecutor<TestCase> {
}