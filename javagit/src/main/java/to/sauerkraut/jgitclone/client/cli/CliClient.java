/*
 * ====================================================================
 * Copyright (c) 2008 JavaGit Project.  All rights reserved.
 *
 * This software is licensed using the GNU LGPL v2.1 license.  A copy
 * of the license is included with the distribution of this source
 * code in the LICENSE.txt file.  The text of the license can also
 * be obtained at:
 *
 *   http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 *
 * For more information on the JavaGit project, see:
 *
 *   http://www.javagit.com
 * ====================================================================
 */
package to.sauerkraut.jgitclone.client.cli;

import to.sauerkraut.jgitclone.client.IClient;
import to.sauerkraut.jgitclone.client.IGitClone;
import to.sauerkraut.jgitclone.client.IGitInit;

/**
 * Command-line implementation of the <code>IClient</code> interface.
 */
public class CliClient implements IClient {

  public IGitInit getGitInitInstance() {
    return new CliGitInit();
  }
    
  public IGitClone getGitCloneInstance() {
    return new CliGitClone();
  }

}
