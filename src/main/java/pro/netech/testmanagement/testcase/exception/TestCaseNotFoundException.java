package pro.netech.testmanagement.testcase.exception;

public class TestCaseNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public TestCaseNotFoundException(Long id) {
        super("Test case not found with id: " + id);
    }
}