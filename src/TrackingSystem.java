import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TrackingSystem {

    private List<Package> listaPaquetes;

    public TrackingSystem() {
        this.listaPaquetes = new ArrayList<Package>();
    }
    public void addPackage(Package pkg){
        listaPaquetes.add(pkg);
    }

    public boolean removePackage(String trackingNumber) {
        Package p;
        for (int i=0;i<listaPaquetes.size();i++) {
            p=listaPaquetes.get(i);
            if(p.getTrackingNumber().equals(trackingNumber)){
                listaPaquetes.remove(i);
                return true;
            }
        }
        return false;
    }

    public Package searchByRecipientAddress (Address recipientAddress){
        for (Package p : listaPaquetes) {
            if(p.getRecipientAddress().equals(recipientAddress)){
                return p;
            }
        }
        return null;
    }


    public Package searchByTrackingNumber(String trackingNumber) {
        try{
            int soloNumTrcking=Integer.parseInt(trackingNumber.substring(3));

            int izquierda = Integer.parseInt(listaPaquetes.get(0).getTrackingNumber().substring(3));
            int derecha = Integer.parseInt(listaPaquetes.get(listaPaquetes.size()-1).getTrackingNumber().substring(3));

            while (izquierda <= derecha) {
                int medio = (izquierda + derecha) / 2;
                int condicion=Integer.parseInt(listaPaquetes.get(medio).getTrackingNumber().substring(3));
                if (condicion==soloNumTrcking) {//nums[medio] == target
                    return listaPaquetes.get(medio);
                } else if (condicion < soloNumTrcking) {
                    izquierda = medio + 1;
                } else {
                    derecha = medio - 1;
                }
            }
        }catch (IndexOutOfBoundsException e) {
            return null;
        }

        return null;
    }


    public List<Package> searchByCity(String city){
        List<Package> paquetesporCiudad=new ArrayList<Package>();
        for (Package p : listaPaquetes) {
            if(p.getRecipientAddress().getCity().equals(city)){
                paquetesporCiudad.add(p);
            }
        }
        return paquetesporCiudad;
    }

    public String getLastPackageCode() {
        return listaPaquetes.get(listaPaquetes.size()-1).getTrackingNumber();
    }

    public String mostrarLista(List<Package> lista){
        String cad="";
        for (Package p : lista) {
            cad=cad+p.toString();

        }
        return cad;
    }

    public void Quemardatos(){
            listaPaquetes.add(new Package(new Address("Av. 1","Quito","Estado  1","123"),new Address("Calle A","Ambato","Estado R1","987"), LocalDate.of(2023,5,12)));
        listaPaquetes.add(new Package(new Address("Av. 2","Guayaquil","Estado  2","456"),new Address("Calle B","Quito","Estado R2","654"),LocalDate.of(2023,5,12)));
        listaPaquetes.add(new Package(new Address("Av. 3","Cuenca","Estado  3","789"),new Address("Calle C","Riobamba","Estado R3","321"),LocalDate.of(2023,5,12)));
        listaPaquetes.add(new Package(new Address("Av. 4","Ambato","Estado  4","012"),new Address("Calle D","Guayaquil","Estado R4","098"),LocalDate.of(2023,5,12)));
        listaPaquetes.add(new Package(new Address("Av. 5","Manta","Estado  5","345"),new Address("Calle E","Cuenca","Estado R5","765"),LocalDate.of(2023,5,12)));
        listaPaquetes.add(new Package(new Address("Av. 6","Loja","Estado  6","678"),new Address("Calle F","Manta","Estado R6","432"),LocalDate.of(2023,5,12)));
    }




    @Override
    public String toString() {
        return "TrackingSystem{" +
                "packages=" + listaPaquetes +
                '}';
    }

}
