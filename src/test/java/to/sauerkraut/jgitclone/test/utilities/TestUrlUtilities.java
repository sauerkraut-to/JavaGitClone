package to.sauerkraut.jgitclone.test.utilities;

import to.sauerkraut.jgitclone.api.url.FtpUrl;
import to.sauerkraut.jgitclone.api.url.FileUrl;
import to.sauerkraut.jgitclone.api.url.HttpsUrl;
import to.sauerkraut.jgitclone.api.url.HttpUrl;
import to.sauerkraut.jgitclone.api.JavaGitException;
import to.sauerkraut.jgitclone.utilities.UrlUtilities;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.Assert.assertEquals;

/**
 * Description : URL utilities testing
 * Date: 03-Mar-2014
 * Time: 7:43 PM
 */
public class TestUrlUtilities {

    @Test
    public void testFTP() throws MalformedURLException, JavaGitException {
        FtpUrl url = (FtpUrl) UrlUtilities.url2JavaGitUrl(new URL("ftp", "host", "file"));
        assertEquals("ftp://host/file", url.toString());
    }

    @Test(expected = MalformedURLException.class)
    public void testFTPs() throws MalformedURLException, JavaGitException {
        // FTPs is an unknown protocol to Java unless a custom handler is added
        new URL("ftps", "host", "file");
    }

    @Test
    public void testFile() throws MalformedURLException, JavaGitException {
        FileUrl url = (FileUrl) UrlUtilities.url2JavaGitUrl(new URL("file", null, "myFile"));
        assertEquals("file:///myFile", url.toString());
    }

    @Test
    public void testHttps() throws MalformedURLException, JavaGitException {
        HttpsUrl url = (HttpsUrl) UrlUtilities.url2JavaGitUrl(new URL("https", "host", "myFile"));
        assertEquals("https://host/myFile", url.toString());
    }

    @Test
    public void testHttp() throws MalformedURLException, JavaGitException {
        HttpUrl url = (HttpUrl) UrlUtilities.url2JavaGitUrl(new URL("http", "host", "myFile"));
        assertEquals("http://host/myFile", url.toString());
    }

    @Test(expected = MalformedURLException.class)
    public void testSSH() throws MalformedURLException, JavaGitException {

        // SSH is an unknown protocol to Java unless a custom handler is added
        new URL("ssh", "host", "myFile");
    }

    @Test(expected = MalformedURLException.class)
    public void testRsync() throws MalformedURLException, JavaGitException {

        // RSYNC is an unknown protocol to Java unless a custom handler is added
        new URL("rsync", "host", "myFile");
    }


    @Test(expected = MalformedURLException.class)
    public void testGit() throws MalformedURLException, JavaGitException {
        // GIT is an unknown protocol to Java unless a custom handler is added
        new URL("git", "host", "myFile");
    }
}
