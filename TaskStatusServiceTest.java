package sit707.ontrack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TaskStatusServiceTest {

    private TaskStatusService service;

    @Before
    public void setUp() {
        service = new TaskStatusService();
    }

    @Test
    public void testSubmittedTaskWaitingForFeedback() {
        String result = service.getTaskStatusMessage("S123", "7.1P", "SUBMITTED");

        assertEquals(
            "Task 7.1P for student S123 is submitted and waiting for tutor feedback.",
            result
        );
    }

    @Test
    public void testReviewedTaskWithFeedbackAvailable() {
        String result = service.getTaskStatusMessage("S123", "7.1P", "REVIEWED");

        assertEquals(
            "Task 7.1P for student S123 has been reviewed. Feedback is available.",
            result
        );
    }

    @Test
    public void testResubmissionRequiredTask() {
        String result = service.getTaskStatusMessage("S123", "7.1P", "RESUBMIT");

        assertEquals(
            "Task 7.1P for student S123 requires resubmission.",
            result
        );
    }

    @Test
    public void testInvalidStudentId() {
        String result = service.getTaskStatusMessage("", "7.1P", "SUBMITTED");

        assertEquals("Invalid student ID.", result);
    }

    @Test
    public void testInvalidTaskId() {
        String result = service.getTaskStatusMessage("S123", "", "SUBMITTED");

        assertEquals("Invalid task ID.", result);
    }

    @Test
    public void testInvalidStatus() {
        String result = service.getTaskStatusMessage("S123", "7.1P", "");

        assertEquals("Invalid task status.", result);
    }

    @Test
    public void testUnknownStatus() {
        String result = service.getTaskStatusMessage("S123", "7.1P", "PENDING");

        assertEquals("Task status is unknown.", result);
    }
}