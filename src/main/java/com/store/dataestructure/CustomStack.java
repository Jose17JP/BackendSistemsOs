package com.store.dataestructure;



import com.store.model.AuditAction;

import java.util.Optional;

public class CustomStack {
    private NodoPila tope; // atri.. de la pila que apunta al nodo de arriba
    private int size;

    public CustomStack() {
        this.tope = null; // porque la pila nace vacia
        this.size = 0;

    }
    public boolean isEmpty() {
        return tope == null;
    }
    public void push(AuditAction accion) {
        NodoPila nuevo = new NodoPila(accion);
        nuevo.setNext(tope);
        tope = nuevo;
        size++; // va sumando 1

    }
    public AuditAction pop() {
        if (isEmpty()) {
            return null;
        }
        AuditAction safed = tope.getAccion();
        tope = tope.getNext();
        size--;
        return safed;
    }
    public AuditAction peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.getAccion();

    }




}
