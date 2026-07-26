package pro.netech.testmanagement.testcase.mapper;

import org.springframework.stereotype.Component;

import pro.netech.testmanagement.testcase.dto.TestCaseRequest;
import pro.netech.testmanagement.testcase.dto.TestCaseResponse;
import pro.netech.testmanagement.testcase.entity.TestCase;

@Component
public class TestCaseMapper {

	public TestCase toEntity(TestCaseRequest request) {
		return new TestCase(null, request.getTitle(), request.getDescription(), request.getPriority(),
				request.getStatus(), request.getAutomated(), null, null);
	}

	public TestCaseResponse toResponse(TestCase entity) {
		return new TestCaseResponse(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getPriority(),
				entity.getStatus(), entity.getAutomated(), entity.getCreatedAt(), entity.getUpdatedAt());
	}

	public void updateEntity(TestCase entity, TestCaseRequest request) {
		entity.setTitle(request.getTitle());
		entity.setDescription(request.getDescription());
		entity.setPriority(request.getPriority());
		entity.setStatus(request.getStatus());
		entity.setAutomated(request.getAutomated());
	}
}