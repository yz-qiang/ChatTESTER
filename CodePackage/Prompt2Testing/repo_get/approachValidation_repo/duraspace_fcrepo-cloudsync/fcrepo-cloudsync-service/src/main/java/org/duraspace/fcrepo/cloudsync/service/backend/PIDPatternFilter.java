package org.duraspace.fcrepo.cloudsync.service.backend;

import com.github.cwilper.ttff.AbstractFilter;

import java.util.regex.Pattern;

public class PIDPatternFilter extends AbstractFilter<String> {

    private final String pattern;

    public PIDPatternFilter(String pattern) {
        this.pattern = pattern;
    }

    public String accept(String value) {
        if (isPid(value) && (pattern == null
                || pattern.equals("*")
                || Pattern.matches(pattern, value)) ) {
            return value;
        } else {
            return null;
        }
    }

    // TODO: Make PID syntax checks more robust
    private boolean isPid(String value) {
        if ( (value == null)
                || (value.indexOf("+") != -1)
                || (value.indexOf("/") != -1)
                || (value.indexOf(" ") != -1) ) {
            return false;
        }
        int i = value.indexOf(":");
        return i > 0 && i < (value.length() - 1) && value.lastIndexOf(":") == i;
    }
}
