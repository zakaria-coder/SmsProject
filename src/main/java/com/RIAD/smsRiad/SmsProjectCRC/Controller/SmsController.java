package com.RIAD.smsRiad.SmsProjectCRC.Controller;

import com.RIAD.smsRiad.SmsProjectCRC.Model.SmsHistorique;
import com.RIAD.smsRiad.SmsProjectCRC.Service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/api/otp")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/{phoneNumber}")
    public Optional<SmsHistorique> getLastOtp(@PathVariable String phoneNumber) {
        return Optional.ofNullable(smsService.findLatestOtpByPhoneNumber(phoneNumber));
    }

    // Exception handler for EntityNotFoundException
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Exception handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}