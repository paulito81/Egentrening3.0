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
    private UserJPATester jpaTester;

    @Inject
    private UserH2Tester h2Tester;

    public void callService() {
        jpaTester.execute();
        h2Tester.execute();
    }

    public static void main(String[] args) {

        WeldContainer container = new Weld().initialize();
        Instance<Main> main = container.instance().select(Main.class);
        main.get().callService();
        container.destroy(main);
        container.close();
    }
}
