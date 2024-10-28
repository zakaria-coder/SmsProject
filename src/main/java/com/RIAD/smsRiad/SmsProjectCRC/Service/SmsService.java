package com.RIAD.smsRiad.SmsProjectCRC.Service;

import com.RIAD.smsRiad.SmsProjectCRC.Model.SmsHistorique;
import com.RIAD.smsRiad.SmsProjectCRC.Repository.SmsHistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class SmsService {

    @Autowired
    private SmsHistoriqueRepository smsHistoriqueRepository;

    public SmsHistorique findLatestOtpByPhoneNumber(String numTel) {
        if (numTel == null || numTel.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }

        return smsHistoriqueRepository.findFirstByNumTelOrderByDateEnvoiDesc(numTel)
                .orElseThrow(() -> new EntityNotFoundException("No OTP found for phone number: " + numTel));
    }
}