package br.com.jamesson.smart.oven.api.controller;

import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationUpdateResult;
import br.com.jamesson.smart.oven.api.service.CalibrationService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@Controller("calibrations")
public class CalibrationsController {

    private final CalibrationService calibrationService;

    @Inject
    public CalibrationsController(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    @Get("/calibrate")
    public Mono<CalibrationUpdateResult> getCalibrate(){
        Mono<CalibrationUpdateResult> result = calibrationService.calibrateOven();
        return result;
    }

}
