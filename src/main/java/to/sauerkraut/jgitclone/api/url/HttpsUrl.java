package to.sauerkraut.jgitclone.api.url;

import to.sauerkraut.jgitclone.api.JavaGitException;

/**
 * Description : JavaGit Secure HTTP URL
 * Date: 2/23/14
 * Time: 7:32 PM
 */
public class HttpsUrl
        extends JavaGitUrl {

    public HttpsUrl(String host, int port, String file) {
        super(GitProtocol.HTTPS, null, host, port, file);
    }

    public HttpsUrl(String host, String file)  {
        super(GitProtocol.HTTPS, null, host, 443, file);
    }

}
