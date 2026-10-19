package com.store.model;

import java.math.BigDecimal;

public class AuditAction {
    private Long productId;
    private Campo campo;
    private BigDecimal valorAnterior;

    public AuditAction(Long productId, Campo campo, BigDecimal valorAnterior) {
        this.productId = productId;
        this.campo = campo;
        this.valorAnterior = valorAnterior;
    }
    public Long getProductId() {
        return productId;
    }
    public Campo getCampo() {
        return campo;
    }
    public BigDecimal getValorAnterior() {
        return valorAnterior;
    }
}
