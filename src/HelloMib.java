import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.mo.DefaultMOFactory;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.agent.mo.MOFactory;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.log.LogFactory;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;


//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class HelloMib implements MOGroup 
{
	private static final LogAdapter LOGGER =  LogFactory.getLogger(HelloMib.class);

	private MOFactory moFactory = DefaultMOFactory.getInstance();

	public static final OID oidHelloMib = new OID(new int[] {  });

	public static final OID oidSysDescr = new OID(new int[] { 1,3,6,1,2,1,4,1,1949,1,0 });
	public static final OID oidSysTest = new OID(new int[] { 1,3,6,1,2,1,4,1,1949,2,0 });
	private MOScalar sysDescr;
	private MOScalar sysTest;

	protected HelloMib() {

	}

	public HelloMib(MOFactory moFactory) {
	  createMO(moFactory);

	}

	protected void createMO(MOFactory moFactory) {
	  addTCsToFactory(moFactory);
	  sysDescr = 
	    moFactory.createScalar(oidSysDescr,
	                           moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE), 
	                           new OctetString("2222222222222"));
	  sysTest = 
	    moFactory.createScalar(oidSysTest,
	                           moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE), 
	                           new OctetString("test"));
	  
  
  
}
	
	public MOScalar getSysDescr() {
	  return sysDescr;
	}
	public MOScalar getSysTest() {
	  return sysTest;
	}
	
	public void registerMOs(MOServer server, OctetString context) 
	  throws DuplicateRegistrationException 
	{
	  server.register(this.sysDescr, context);
	  server.register(this.sysTest, context);

	}
	
	public void unregisterMOs(MOServer server, OctetString context) {

	  server.unregister(this.sysDescr, context);
	  server.unregister(this.sysTest, context);

	}
	
	protected void addTCsToFactory(MOFactory moFactory) {
	}
	
	public void addImportedTCsToFactory(MOFactory moFactory) {
	}
}