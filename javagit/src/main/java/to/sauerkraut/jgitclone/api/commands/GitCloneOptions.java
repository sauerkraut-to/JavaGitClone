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
package to.sauerkraut.jgitclone.api.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to manage passing options to the <code>GitClone</code> command.
 */
public class GitCloneOptions extends OptionsBase {
    
    public GitCloneOptions() {
        setDepth(0);
    }

    public void setDepth(int depth) {
        setOption(Option.DEPTH, depth);
    }

    public int getDepth() {
        return (Integer) getOption(Option.DEPTH);
    }
    
    private enum Option implements ICommandOption {
        DEPTH("--depth", !Option.HAS_EQUALS, 0);
        public static final String NO_OPTION_SET = "";

        public static final boolean HAS_EQUALS = true;
        private final String option;
        private final boolean hasEquals;


        private Object deflt;


        Option(String option, boolean hasEquals, Object deflt) {
            this.option = option;
            this.hasEquals = hasEquals;
            this.deflt = deflt;
        }

        public List<String> getOption(Object value) {

            List<String> ret = new ArrayList<String>();

            if (value instanceof Boolean)
                ret.add((Boolean) value ? option : NO_OPTION_SET);
            else {
                if (hasEquals)
                    ret.add(option + "=" + value.toString());
                else {
                    ret.add(option );
                    ret.add( value.toString());
                }
            }

            return ret;
        }

        public Object getDefault() {
            return deflt;
        }

    }
}
