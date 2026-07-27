package pro.netech.testmanagement.testcase.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pro.netech.testmanagement.testcase.dto.TestCaseRequest;
import pro.netech.testmanagement.testcase.dto.TestCaseResponse;
import pro.netech.testmanagement.testcase.enums.Priority;
import pro.netech.testmanagement.testcase.enums.TestStatus;
import pro.netech.testmanagement.testcase.service.TestCaseService;

@RestController
@RequestMapping("/testcases")
@RequiredArgsConstructor
@Tag(
        name = "Test Cases",
        description = "Operations for managing software test cases"
)
public class TestCaseController {

    private final TestCaseService testCaseService;

    @Operation(
            summary = "Get test cases",
            description = "Returns test cases using pagination and sorting."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Test cases retrieved successfully"
    )
    @GetMapping
    public ResponseEntity<Page<TestCaseResponse>> getAllTestCases(
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false) TestStatus status,
            @RequestParam(required = false) Boolean automated,
            @RequestParam(required = false) String title,
            @ParameterObject Pageable pageable) {

        Page<TestCaseResponse> responses =
                testCaseService.getAllTestCases(
                        priority,
                        status,
                        automated,
                        title,
                        pageable
                );

        return ResponseEntity.ok(responses);
    }

    @Operation(
            summary = "Get a test case by ID",
            description = "Returns a software test case using its unique identifier."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Test case retrieved successfully"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Test case not found"
    )
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponse> getTestCaseById(
            @PathVariable Long id) {

        TestCaseResponse response =
                testCaseService.getTestCaseById(id);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create a new test case",
            description = "Creates a new software test case."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Test case created successfully"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid test case data"
    )
    @PostMapping
    public ResponseEntity<TestCaseResponse> createTestCase(
            @Valid @RequestBody TestCaseRequest request) {

        TestCaseResponse response =
                testCaseService.createTestCase(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(
            summary = "Update a test case",
            description = "Updates an existing software test case using its unique identifier."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Test case updated successfully"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid test case data"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Test case not found"
    )
    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponse> updateTestCase(
            @PathVariable Long id,
            @Valid @RequestBody TestCaseRequest request) {

        TestCaseResponse response =
                testCaseService.updateTestCase(id, request);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete a test case",
            description = "Deletes a software test case using its unique identifier."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Test case deleted successfully"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Test case not found"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(
            @PathVariable Long id) {

        testCaseService.deleteTestCase(id);

        return ResponseEntity.noContent().build();
    }
}