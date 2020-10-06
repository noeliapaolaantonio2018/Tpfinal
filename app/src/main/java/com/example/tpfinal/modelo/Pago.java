package com.example.tpfinal.modelo;

import java.io.Serializable;
import java.util.Date;

public class Pago implements Serializable {

    private int idPago;
    private int numero;
    private int idContrato;
    private Contrato contrato;
    private double importe;
    private Date fechaDePago;

    private Pago() {}

    public Pago(int idPago, int numero, int idContrato, Contrato contrato, double importe, Date fechaDePago) {
        this.idPago = idPago;
        this.numero = numero;
        this.idContrato = idContrato;
        this.contrato = contrato;
        this.importe = importe;
        this.fechaDePago = fechaDePago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }
}
