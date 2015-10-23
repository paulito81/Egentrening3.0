import console.LocationH2Tester;
import console.LocationJPATester;
import console.UserH2Tester;
import console.UserJPATester;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by Paul on 22.10.2015.
 */
public class Main {

    @Inject
    private UserJPATester userJPATester;

    @Inject
    private LocationJPATester locationJPATester;

    @Inject
    private UserH2Tester userH2Tester;

    @Inject
    private LocationH2Tester locationH2Tester;

    public void callService() {
        userJPATester.execute();
        userH2Tester.execute();
        locationH2Tester.execute();
        locationJPATester.execute();
    }

    public static void main(String[] args) {

        WeldContainer container = new Weld().initialize();
        Instance<Main> main = container.instance().select(Main.class);
        main.get().callService();
        container.destroy(main);
        container.close();
    }
}
