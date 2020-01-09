import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connect conn = null;
		int flags = 0;

		try {
			
			
			conn = new Connect("qemu:///system", false);

			String dumpxml = "<domain type='kvm'>"+
			  "<name>tt2</name>"+
			  "<memory>524288</memory>"+
			  "<currentMemory>524288</currentMemory>"+
			  "<vcpu>1</vcpu>"+
			  "<os>"+
			  "  <type arch='i686' machine='pc-0.11'>hvm</type>"+
			  "  <boot dev='hd'/>"+
			  "</os>"+
			  "<features>"+
			  "  <acpi/>"+
			  "  <apic/>"+
			   " <pae/>"+
			  "</features>"+
			  "<clock offset='utc'/>"+
			  "<on_poweroff>destroy</on_poweroff>"+
			  "<on_reboot>restart</on_reboot>"+
			  "<on_crash>restart</on_crash>"+
			  "<devices>"+
			  "  <emulator>/usr/bin/qemu-kvm</emulator>"+
			  "  <disk type='file' device='disk'>"+
			  "    <driver name='qemu' cache='none'/>"+
			  "    <source file='/var/lib/libvirt/images/tt.img'/>"+
			  "    <target dev='hda' bus='ide'/>"+
			  "  </disk>"+
			  "  <interface type='network'>"+
			  "    <mac address='54:52:00:02:02:2c'/>"+
			  "    <source network='default'/>"+
			  "  </interface>"+
			  "  <serial type='pty'>"+
			  "    <target port='0'/>"+
			  "  </serial>"+
			  "  <console type='pty'>"+
			  "    <target port='0'/>"+
			  "  </console>"+
			  "  <input type='mouse' bus='ps2'/>"+
			  "  <graphics type='vnc' port='-1' autoport='yes' keymap='en-us'/>"+
			  "</devices>"+
			"</domain>";
			
			
			Domain dm = null;
			try{
				dm =conn.domainLookupByName("tt2");
			}
			catch (LibvirtException e) {
				// TODO: handle exception
			}
			if(dm!=null)
			{
				
				dm.undefine();
				
			}
			Domain dm1 = conn.domainDefineXML(dumpxml);
			dm1.undefine();
		
			Domain dm2 = conn.domainDefineXML(dumpxml);
			dm2.undefine();
						
		} catch (LibvirtException e) {
			System.out.println("exception caught:" + e);
			System.out.println(e.getError());

			return;
		}
        
        System.out.println("Clean exit");

	}

}
