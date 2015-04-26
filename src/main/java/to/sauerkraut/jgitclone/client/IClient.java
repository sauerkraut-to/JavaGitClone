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
package to.sauerkraut.jgitclone.client;

/**
 * An interface to represent a git client type, such as a command-line client.
 */
public interface IClient {
  
  /**
   * Gets an instance of <code>IGitInit</code>
   * 
   * @return An instance of <code>IGitInit</code>
   */
  public IGitInit getGitInitInstance();
 
  /**
   * Gets an instance of <code>IGitClone</code>
   * 
   * @return An instance of <code>IGitClone</code>
   */
  public IGitClone getGitCloneInstance();
}
