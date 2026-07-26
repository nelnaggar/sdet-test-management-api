package pro.netech.testmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.netech.testmanagement.entity.TestCase;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

}