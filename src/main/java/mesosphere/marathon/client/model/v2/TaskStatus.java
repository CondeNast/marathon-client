package mesosphere.marathon.client.model.v2;

public enum TaskStatus {
    TASK_STAGING,
    TASK_STARTING,
    TASK_RUNNING,
    TASK_LOST,
    TASK_KILLING,
    TASK_FINISHED,
    TASK_KILLED,
    TASK_ERROR
}
