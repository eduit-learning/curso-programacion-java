package eduit.learning.modulo3.laboratorio.modelo;

import java.util.Date;

public final class Venta {

    private int ventaID;
    private String codigoProducto;
    private String nombreProducto;
    private double cantidad;
    private Date fecha;
    private String sucursal;
    private double precioUnitario;
    private double factor;
    private String uri;
    private String region;
    private String idioma;
    private double importe;
    private double importeUSD;

    public Venta() {
    }

    public int getVentaID() {
        return this.ventaID;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getSucursal() {
        return this.sucursal;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public double getFactor() {
        return this.factor;
    }

    public String getUri() {
        return this.uri;
    }

    public String getRegion() {
        return this.region;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public double getImporte() {
        return this.importe;
    }

    public double getImporteUSD() {
        return this.importeUSD;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setImporteUSD(double importeUSD) {
        this.importeUSD = importeUSD;
    }
}
