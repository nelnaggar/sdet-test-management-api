package pro.netech.testmanagement.testcase.dto;

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
public class TestCaseResponse {

    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private TestStatus status;
    private Boolean automated;
}