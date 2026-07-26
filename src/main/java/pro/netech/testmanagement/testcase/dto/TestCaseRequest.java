package pro.netech.testmanagement.testcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.netech.testmanagement.testcase.enums.Priority;
import pro.netech.testmanagement.testcase.enums.TestStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseRequest {

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Priority is mandatory")
    private Priority priority;

    @NotNull(message = "Status is mandatory")
    private TestStatus status;

    @NotNull(message = "Automation status is mandatory")
    private Boolean automated;
}