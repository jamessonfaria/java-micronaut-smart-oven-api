package br.com.jamesson.smart.oven.api.client;

import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationParameters;
import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.retry.annotation.Retryable;
import reactor.core.publisher.Mono;

@Client("http://localhost:8081")
public interface DeclarativeCalibrationsClient {

    @Get("/calibrations/{modelName}")
    //@Retryable(attempts = "3", delay = "2s")
    //@CircuitBreaker
    Mono<CalibrationParameters> getCalibrationParameters(String modelName);

    @Put("calibrations/updates")
    Mono<CalibrationUpdateResult> updateCalibrationParameters(@Body CalibrationParameters params);
}
