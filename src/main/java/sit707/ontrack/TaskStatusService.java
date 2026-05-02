package sit707.ontrack;

public class TaskStatusService {

    public String getTaskStatusMessage(String studentId, String taskId, String status) {

        if (studentId == null || studentId.trim().isEmpty()) {
            return "Invalid student ID.";
        }

        if (taskId == null || taskId.trim().isEmpty()) {
            return "Invalid task ID.";
        }

        if (status == null || status.trim().isEmpty()) {
            return "Invalid task status.";
        }

        if (status.equalsIgnoreCase("SUBMITTED")) {
            return "Task " + taskId + " for student " + studentId
                    + " is submitted and waiting for tutor feedback.";
        }

        if (status.equalsIgnoreCase("REVIEWED")) {
            return "Task " + taskId + " for student " + studentId
                    + " has been reviewed. Feedback is available.";
        }

        if (status.equalsIgnoreCase("RESUBMIT")) {
            return "Task " + taskId + " for student " + studentId
                    + " requires resubmission.";
        }

        return "Task status is unknown.";
    }
}