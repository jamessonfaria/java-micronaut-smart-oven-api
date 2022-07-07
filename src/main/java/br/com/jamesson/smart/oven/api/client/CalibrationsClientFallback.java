package br.com.jamesson.smart.oven.api.client;

import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationParameters;
import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationUpdateResult;
import io.micronaut.retry.annotation.Fallback;
import reactor.core.publisher.Mono;

@Fallback
public class CalibrationsClientFallback implements DeclarativeCalibrationsClient {
    @Override
    public Mono<CalibrationParameters> getCalibrationParameters(String modelName) {
        return Mono.just(new CalibrationParameters(modelName, 0, 0));
    }

    @Override
    public Mono<CalibrationUpdateResult> updateCalibrationParameters(CalibrationParameters params) {
        return Mono.just(new CalibrationUpdateResult(false));
    }
}
