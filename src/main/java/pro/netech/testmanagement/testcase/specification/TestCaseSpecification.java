package pro.netech.testmanagement.testcase.specification;

import org.springframework.data.jpa.domain.Specification;

import pro.netech.testmanagement.testcase.entity.TestCase;
import pro.netech.testmanagement.testcase.enums.Priority;
import pro.netech.testmanagement.testcase.enums.TestStatus;

public final class TestCaseSpecification {

    private TestCaseSpecification() {
    }

    public static Specification<TestCase> hasPriority(
            Priority priority) {

        return (root, query, criteriaBuilder) -> {

            if (priority == null) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.equal(
                    root.get("priority"),
                    priority
            );
        };
    }

    public static Specification<TestCase> hasStatus(
            TestStatus status) {

        return (root, query, criteriaBuilder) -> {

            if (status == null) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.equal(
                    root.get("status"),
                    status
            );
        };
    }

    public static Specification<TestCase> isAutomated(
            Boolean automated) {

        return (root, query, criteriaBuilder) -> {

            if (automated == null) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.equal(
                    root.get("automated"),
                    automated
            );
        };
    }
    
    public static Specification<TestCase> titleContains(
            String title) {

        return (root, query, criteriaBuilder) -> {

            if (title == null || title.isBlank()) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("title")),
                    "%" + title.toLowerCase() + "%"
            );
        };
    }
}