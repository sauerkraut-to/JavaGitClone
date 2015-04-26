package to.sauerkraut.jgitclone.api.url;

import to.sauerkraut.jgitclone.api.JavaGitException;

import java.io.File;

/**
 * Description : JavaGit File URL
 * Date: 2/23/14
 * Time: 7:32 PM
 */
public class FileUrl
        extends JavaGitUrl {

    public FileUrl(String file) {
        super(GitProtocol.FILE, null, null, null, file);
    }

    public FileUrl(File repoPath) {
        this(repoPath.getAbsolutePath());
    }
}
