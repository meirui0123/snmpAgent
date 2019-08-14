
import org.snmp4j.agent.mo.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.smi.OctetString;

public class HelloModules implements MOGroup {

  private static final LogAdapter LOGGER =
      LogFactory.getLogger(HelloModules.class);

  private HelloMib HelloMib;

  private MOFactory factory;

  public HelloModules() {
   HelloMib = new HelloMib();

  }

  public HelloModules(MOFactory factory) {
   HelloMib = new HelloMib(factory);

  }

  public void registerMOs(MOServer server, OctetString context)
    throws DuplicateRegistrationException
  {
   HelloMib.registerMOs(server, context);

  }

  public void unregisterMOs(MOServer server, OctetString context) {
   HelloMib.unregisterMOs(server, context);

  }

  public HelloMib getSnmp4jDemoMib() {
    return HelloMib;
  }


}
