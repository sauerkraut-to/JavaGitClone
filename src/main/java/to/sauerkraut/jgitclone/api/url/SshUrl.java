package to.sauerkraut.jgitclone.api.url;

import to.sauerkraut.jgitclone.api.JavaGitException;

/**
 * Description : JavaGit SSH URL
 * Date: 2/23/14
 * Time: 7:32 PM
 */
public class SshUrl
    extends JavaGitUrl {

    public SshUrl(String host, String user, int port, String file){
        super(GitProtocol.SSH, user, host, port, file);
    }

    public SshUrl(String host, String file)  {
        super(GitProtocol.SSH, null, host, 22, file);
    }
}
