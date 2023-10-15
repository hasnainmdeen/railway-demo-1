package com.aws.codestar.projecttemplates.model;

public class CheckConflictResponse {
    private boolean success;

    public CheckConflictResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
