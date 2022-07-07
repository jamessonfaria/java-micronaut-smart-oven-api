package br.com.jamesson.smart.oven.api.client;

import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationParameters;
import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationUpdateResult;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Client("http://localhost:8081")
public interface DeclarativeCalibrationsClient {

    @Get("/calibrations/{modelName}")
    Mono<CalibrationParameters> getCalibrationParameters(String modelName);

    @Put("calibrations/updates")
    Mono<CalibrationUpdateResult> updateCalibrationParameters(@Body CalibrationParameters params);
}
