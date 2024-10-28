package com.RIAD.smsRiad.SmsProjectCRC.Model;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sms_historique")
public class SmsHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing primary key
    @Column(name = "sms_id", nullable = false)
    private Integer smsId;

    @Column(name = "num_tel", length = 50, nullable = false)
    private String numTel;

    @Column(name = "message", nullable = false, columnDefinition = "text")
    private String message;

    @Column(name = "date_envoi", columnDefinition = "timestamp without time zone default now()")
    private LocalDateTime dateEnvoi;

    @Column(name = "date_reponse")
    private LocalDateTime dateReponse;

    @Column(name = "type_msg", nullable = false)
    private Integer typeMsg;

    @Column(name = "statut", nullable = false)
    private Integer statut;

    @Column(name = "reference", length = 100)
    private String reference;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "code_partenaire")
    private Integer codePartenaire;

}
