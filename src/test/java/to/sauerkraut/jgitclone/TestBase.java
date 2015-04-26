package to.sauerkraut.jgitclone;

import to.sauerkraut.jgitclone.api.JavaGitConfiguration;
import to.sauerkraut.jgitclone.api.JavaGitException;
import to.sauerkraut.jgitclone.test.utilities.Deletor;
import to.sauerkraut.jgitclone.test.utilities.TestProperty;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import java.io.IOException;

/**
 * Description : Base class for testing
 * Date: 3/30/13
 * Time: 2:14 AM
 */
@Ignore
public class TestBase {

    private Deletor d = null;

    @Before
    public void setUp() throws IOException, JavaGitException {
        JavaGitConfiguration.setGitPath(TestProperty.GIT_PATH.asString());
    }


    @After
    public void tearDown() {
        try {
            getDeletor().delete();
        } catch (JavaGitException e) {
            e.printStackTrace();
        }
    }

    protected Deletor getDeletor() {
        if ( d == null)
            d = new Deletor();

        return d;
    }
}
