package utn.credicoop.msproductobase;

public class RtaProductoBaseDTO {

    private String status;
    private String motivo;

    public RtaProductoBaseDTO(){
        super();
    }

    public RtaProductoBaseDTO(String status, String motivo) {
        this.status = status;
        this.motivo = motivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
