package pro.netech.testmanagement.testcase.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pro.netech.testmanagement.testcase.dto.TestCaseRequest;
import pro.netech.testmanagement.testcase.dto.TestCaseResponse;
import pro.netech.testmanagement.testcase.entity.TestCase;
import pro.netech.testmanagement.testcase.enums.Priority;
import pro.netech.testmanagement.testcase.enums.TestStatus;
import pro.netech.testmanagement.testcase.mapper.TestCaseMapper;
import pro.netech.testmanagement.testcase.repository.TestCaseRepository;

@ExtendWith(MockitoExtension.class)
public class TestCaseServiceTest {
	@Mock
	private TestCaseRepository repository;

	@Mock
	private TestCaseMapper mapper;

	@InjectMocks
	private TestCaseService service;
	
	@Test
	void shouldCreateTestCase() {

	    // Arrange
	    TestCaseRequest request = new TestCaseRequest(
	            "Successful user login",
	            "Verify login with valid credentials.",
	            Priority.HIGH,
	            TestStatus.READY,
	            true
	    );

	    TestCase entity = new TestCase(
	            null,
	            request.getTitle(),
	            request.getDescription(),
	            request.getPriority(),
	            request.getStatus(),
	            request.getAutomated(),
	            null,
	            null
	    );

	    TestCase savedEntity = new TestCase(
	            1L,
	            request.getTitle(),
	            request.getDescription(),
	            request.getPriority(),
	            request.getStatus(),
	            request.getAutomated(),
	            null,
	            null
	    );

	    TestCaseResponse expectedResponse = new TestCaseResponse(
	            1L,
	            request.getTitle(),
	            request.getDescription(),
	            request.getPriority(),
	            request.getStatus(),
	            request.getAutomated(),
	            null,
	            null
	    );

	    when(mapper.toEntity(request)).thenReturn(entity);
	    when(repository.save(entity)).thenReturn(savedEntity);
	    when(mapper.toResponse(savedEntity)).thenReturn(expectedResponse);

	    // Act
	    TestCaseResponse actualResponse =
	            service.createTestCase(request);

	    // Assert
	    assertEquals(expectedResponse, actualResponse);

	    verify(mapper).toEntity(request);
	    verify(repository).save(entity);
	    verify(mapper).toResponse(savedEntity);
	}

}
