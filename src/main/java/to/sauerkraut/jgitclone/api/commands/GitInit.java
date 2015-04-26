package to.sauerkraut.jgitclone.api.commands;

import java.io.File;
import java.io.IOException;

import to.sauerkraut.jgitclone.api.JavaGitException;
import to.sauerkraut.jgitclone.client.ClientManager;
import to.sauerkraut.jgitclone.client.IClient;
import to.sauerkraut.jgitclone.client.IGitInit;
import to.sauerkraut.jgitclone.utilities.CheckUtilities;

public class GitInit {
	
	public GitInitResponse init(File repositoryPath, GitInitOptions options) throws JavaGitException, IOException{
		CheckUtilities.checkNullArgument(repositoryPath, "repository");
	    
	    IClient client = ClientManager.getInstance().getPreferredClient();
	    IGitInit gitInit = client.getGitInitInstance();
	    return gitInit.init(repositoryPath,options);
	}
	
	public GitInitResponse init(File repositoryPath) throws JavaGitException, IOException{
		CheckUtilities.checkNullArgument(repositoryPath, "repository");
	    
	    IClient client = ClientManager.getInstance().getPreferredClient();
	    IGitInit gitInit = client.getGitInitInstance();
	    return gitInit.init(repositoryPath);
	}

}
