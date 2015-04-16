package org.codetrip.common.enumerate;

/**
 * Created by RuFeng on 2015/1/29.
 */
public enum JudgeResult {
    COMPILE_ERROR("Compile Error"),
    ACCEPT("Accept"),
    WRONG_ANSWER("Wrong Answer"),
    PRESENTATION_ERROR("Presentation Error"),
    RUNTIME_ERROR("Runtime Error"),
    TIME_LIMIT_EXCEEDED("Time Limit Exceeded"),
    MEMORY_LIMIT_EXCEEDED("Memory Limit Exceeded"),
    OUTPUT_LIMIT_EXCEEDED("Output Limit Exceeded"),
    OUT_OF_CONTEST_TIME("Out Of Contest Time"),
    QUEUE("Queue");

    private String value;

    JudgeResult(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
