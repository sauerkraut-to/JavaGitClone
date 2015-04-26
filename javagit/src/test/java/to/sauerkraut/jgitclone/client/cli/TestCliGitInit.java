package to.sauerkraut.jgitclone.client.cli;

import to.sauerkraut.jgitclone.TestBase;
import to.sauerkraut.jgitclone.api.JavaGitException;
import to.sauerkraut.jgitclone.api.commands.GitInitOptions;
import to.sauerkraut.jgitclone.api.commands.GitInitResponse;
import to.sauerkraut.jgitclone.test.utilities.FileUtilities;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.fail;

public class TestCliGitInit extends TestBase {
    private File repoDirectory;

    @Before
    public void setUp() throws IOException, JavaGitException {
        super.setUp();
        repoDirectory = FileUtilities.createTempDirectory("GitLogTestRepo");
        getDeletor().add(repoDirectory);
    }

    /**
     * Test to verify if git logs is successfully parsing logs
     *
     * @throws IOException
     * @throws JavaGitException
     */
    @Test
    public void testGitInitaliaze() throws IOException, JavaGitException {

        CliGitInit gitInit = new CliGitInit();
        GitInitOptions options = new GitInitOptions();
        GitInitResponse response = gitInit.init(repoDirectory, options);
        if (!response.isInitialized()) {
            fail("Failed to initialize git repository");
        }
    }


}
