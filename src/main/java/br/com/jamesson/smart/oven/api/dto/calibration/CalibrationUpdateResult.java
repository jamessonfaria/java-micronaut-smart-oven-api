package br.com.jamesson.smart.oven.api.dto.calibration;

public class CalibrationUpdateResult {
    private Boolean success;

    public CalibrationUpdateResult() {
    }

    public CalibrationUpdateResult(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CalibrationUpdateResult{" +
                "success=" + success +
                '}';
    }
}
