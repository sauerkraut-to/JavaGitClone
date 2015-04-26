package to.sauerkraut.jgitclone.client;

import java.io.File;
import java.io.IOException;

import to.sauerkraut.jgitclone.api.JavaGitException;
import to.sauerkraut.jgitclone.api.commands.GitInitOptions;
import to.sauerkraut.jgitclone.api.commands.GitInitResponse;


public interface IGitInit {
	
	/**
	 * 
	 * @param repoDirectory The repository Directroy to be initialized as a git repository
	 * @param options	Option to be include while initializing a repository
	 * @return	GitInitResponse object
	 * @throws JavaGitException
	 * @throws IOException
	 */
	public GitInitResponse init(File repoDirectory, GitInitOptions options) throws JavaGitException, IOException;
	
	/**
	 * 
	 * @param repoDirectory The repository Directroy to be initialized as a git repository
	 * @return	GitInitResponse object
	 * @throws JavaGitException
	 * @throws IOException
	 */
	public GitInitResponse init(File repoDirectory) throws JavaGitException, IOException;

}





