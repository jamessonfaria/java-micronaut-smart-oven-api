package br.com.jamesson.smart.oven.api.service;

import br.com.jamesson.smart.oven.api.client.LowLevelCalibrationsClient;
import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationStatus;
import br.com.jamesson.smart.oven.api.dto.calibration.CalibrationUpdateResult;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Singleton
public class CalibrationService {

    private static final Logger logger = LoggerFactory.getLogger(CalibrationService.class);
    private static final String OVEN_MODEL = "PLURAL_OVEN";
    private static final String SERIAL_NO = "123456";

    private LowLevelCalibrationsClient lowLevelClient;

    public CalibrationService(LowLevelCalibrationsClient lowLevelClient) {
        this.lowLevelClient = lowLevelClient;
    }

    public Mono<CalibrationUpdateResult> calibrateOven(){
        return lowLevelClient.getCalibrationParameters(OVEN_MODEL)
                .doOnNext(parameters -> logger.info("Calibrations parameters received {}", parameters))
                .doOnNext(parameters -> logger.info("Calibrations oven ..."))
                .doOnNext(parameters -> logger.info("Oven calibration complete ! Sending updates to cloud..."))
                .flatMap(parameters -> lowLevelClient.updateCalibrationStatus(new CalibrationStatus(OVEN_MODEL, SERIAL_NO, LocalDate.now()))
                .doOnNext(updateResult -> logger.info("Update result received {}", updateResult)));
    }
}
