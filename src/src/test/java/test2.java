import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.MemoryStatistic;
import org.libvirt.NetworkFilter;
import org.libvirt.Secret;


public class test2 {
    
    public static void main(String[] args) {
        try {
            //Connect conn = new Connect("qemu:///system", false);
            Connect conn = new Connect("test:///default", false);
           /* Domain dom = conn.domainLookupByID(1) ;
            for (MemoryStatistic stat : dom.memoryStats(2)) {
                System.out.println(stat.getTag()) ;
                System.out.println(stat.getValue()) ;                
            }*/          
            /*for (String secUUid : conn.listSecrets()) {
                Secret sec = conn.secretLookupByUUIDString(secUUid) ;
                System.out.println(sec.getValue()) ;
            }*/
            for (String nwFilter : conn.listNetworkFilters()) {
                NetworkFilter sec = conn.networkFilterLookupByName(nwFilter) ;
                System.out.println(sec.getXMLDesc()) ;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
