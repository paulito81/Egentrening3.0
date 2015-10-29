import console.JPA.TopicJPATester;
import console.H2.UserH2Tester;
import console.JPA.UserJPATester;
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
    private TopicJPATester topicJPATester;

    @Inject
    private UserH2Tester userH2Tester;



    public void callService() {
        userJPATester.execute();
        userH2Tester.execute();
        topicJPATester.execute();
    }

    public static void main(String[] args) {

        WeldContainer container = new Weld().initialize();
        Instance<Main> main = container.instance().select(Main.class);
        main.get().callService();
        container.destroy(main);
        container.close();
    }
}
