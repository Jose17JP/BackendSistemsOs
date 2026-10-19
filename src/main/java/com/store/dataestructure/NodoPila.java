package com.store.dataestructure;
import com.store.model.AuditAction;
import com.store.dataestructure.Nodo;
public class NodoPila {
    private AuditAction accion;
    private NodoPila next; // apunta al nodo que esta abajo

    public NodoPila(AuditAction accion) {
        this.accion = accion;
        this.next = null;
    }
    public AuditAction getAccion() {
        return  accion;
    }
    public NodoPila getNext() {
        return next;
    }
    public void setNext(NodoPila next) {
        this.next = next;
    }



}
