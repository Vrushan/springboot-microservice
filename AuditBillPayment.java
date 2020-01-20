package com.rhbgroup.dcpbo.customer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "DCP_audit_bill_payment")
public class AuditBillPayment implements Serializable {

    private static final long serialVersionUID = 8969836806914502583L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true )
    private Integer id;

    @Column(name = "audit_id", nullable = false)
    private Integer auditId;

    @Column(name = "details", columnDefinition = "nvarchar(4000)", nullable = false)
    private String details;
}
