package to.sauerkraut.jgitclone.api.url;

import to.sauerkraut.jgitclone.api.JavaGitException;

/**
 * Description : JavaGit RSync URL
 * Date: 2/23/14
 * Time: 7:32 PM
 */
public class RsyncUrl
        extends JavaGitUrl {

    public RsyncUrl(String host, String file) {
        super(GitProtocol.RSYNC, null, host, null, file);
    }

}
