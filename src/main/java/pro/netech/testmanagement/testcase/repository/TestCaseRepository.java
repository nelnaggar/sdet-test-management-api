package pro.netech.testmanagement.testcase.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pro.netech.testmanagement.testcase.enums.Priority;
import pro.netech.testmanagement.testcase.enums.TestStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.netech.testmanagement.testcase.entity.TestCase;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
	
	Page<TestCase> findByPriority(
	        Priority priority,
	        Pageable pageable
	);

	Page<TestCase> findByStatus(
	        TestStatus status,
	        Pageable pageable
	);

	Page<TestCase> findByAutomated(
	        Boolean automated,
	        Pageable pageable
	);

}