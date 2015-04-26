package to.sauerkraut.jgitclone.client.cli;

import to.sauerkraut.jgitclone.TestBase;
import to.sauerkraut.jgitclone.api.JavaGitException;
import to.sauerkraut.jgitclone.api.commands.GitClone;
import to.sauerkraut.jgitclone.api.commands.GitInit;
import to.sauerkraut.jgitclone.api.url.FileUrl;
import to.sauerkraut.jgitclone.test.utilities.FileUtilities;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Description : TOOL DESCRIPTION HERE !!!
 * Date: 12/31/13
 * Time: 6:34 PM
 */
public class TestCliGitClone
    extends TestBase {

    private static final boolean USE_URL = true;
    private File repoPath;

    @Before
    public void setup() throws IOException, JavaGitException {
        super.setUp();
        repoPath = FileUtilities.createTempDirectory("TestCliGitClone");
        getDeletor().add(repoPath);
        new GitInit().init(repoPath);
    }


    @Test
    public void testCloneEmptyRepositoryUseUrl() throws IOException, JavaGitException, URISyntaxException {
        final File cloneFolder = doClone(repoPath, USE_URL);

        assertTrue(cloneFolder.exists());
        assertTrue(cloneFolder.isDirectory());

        final File dotGit = new File(cloneFolder, ".git");
        assertTrue(dotGit.exists());
        assertTrue(dotGit.isDirectory());
    }

    @Test
    public void testCloneEmptyRepositoryUseJavaGitUrl() throws IOException, JavaGitException, URISyntaxException {
        final File cloneFolder = doClone(repoPath, !USE_URL);

        assertTrue(cloneFolder.exists());
        assertTrue(cloneFolder.isDirectory());

        final File dotGit = new File(cloneFolder, ".git");
        assertTrue(dotGit.exists());
        assertTrue(dotGit.isDirectory());
    }

    private File doClone(File repository, boolean useUrl) throws IOException, JavaGitException, URISyntaxException {
        final File cloneFolder = FileUtilities.getNonExistingTempFolder();
        getDeletor().add(cloneFolder);

        final File tmpFolder = new File(System.getProperty("java.io.tmpdir"));

        final GitClone gitClone = new GitClone();
        assertNotNull(gitClone);
        if (useUrl) {
            gitClone.clone(tmpFolder, repository.toURI().toURL(), cloneFolder);
        } else {
            gitClone.clone(tmpFolder, new FileUrl(repository), cloneFolder);
        }
        return cloneFolder;
    }

    @Test
    public void testFailedCloneUseUrl() throws IOException, URISyntaxException, JavaGitException {
        try {
            doClone(FileUtilities.getNonExistingTempFolder(), USE_URL);
        } catch (JavaGitException e) {
            if (e.getCode() != 408000)
                throw e;
        }

    }

    @Test
    public void testFailedCloneUseJavaGitUrl() throws IOException, URISyntaxException, JavaGitException {
        try {
            doClone(FileUtilities.getNonExistingTempFolder(), !USE_URL);
        } catch (JavaGitException e) {
            if (e.getCode() != 408000)
                throw e;
        }

    }
}
