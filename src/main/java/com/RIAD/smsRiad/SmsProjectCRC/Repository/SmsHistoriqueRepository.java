package com.RIAD.smsRiad.SmsProjectCRC.Repository;

import com.RIAD.smsRiad.SmsProjectCRC.Model.SmsHistorique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SmsHistoriqueRepository extends JpaRepository<SmsHistorique, String> {
    Optional<SmsHistorique> findFirstByNumTelOrderByDateEnvoiDesc(String numTel);

}
