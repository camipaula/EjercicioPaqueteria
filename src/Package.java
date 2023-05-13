import java.time.LocalDate;

public class Package {
    private String trackingNumber;
    private Address senderAddress;
    private Address recipientAddress;
    private LocalDate estimatedDeliveryDate;
    private static int contador=0;

    public Package(Address senderAddress, Address recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber=crearTracking();
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private String crearTracking(){
        contador=contador+1;
        return"AA0-"+contador;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }


    @Override
    public String toString() {
        return "Paquete: " +
                "trackingNumber='" + trackingNumber + '\'' +
                ", senderAddress=" + senderAddress +
                ",\n recipientAddress=" + recipientAddress +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                '\n';
    }
}
