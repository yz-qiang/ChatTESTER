package org.duraspace.fcrepo.cloudsync.service.util;

public final class StringUtil {

    private StringUtil() { }

    /**
     * Normalizes the given string by trimming it if non-null and returning
     * null if null or empty.
     *
     * @param val the string value to normalize.
     * @return the normalized value.
     */
    public static String normalize(String val) {
        if (val == null || val.trim().length() == 0) return null;
        return val.trim();
    }

    /**
     * Checks that the given value's normalized length is in the allowed range.
     *
     * @param name the name of the property being checked, for error reporting.
     * @param value the value.
     * @param maxLen the maximum length allowed.
     * @return the normalized value.
     * @throws IllegalArgumentException if the normalized value is null,
     *         zero-length, or exceeds the maximum length specified.
     */
    public static String validate(String name, String value, int maxLen)
            throws IllegalArgumentException {
        String normVal = normalize(value);
        if (normVal == null) {
            throw new IllegalArgumentException("A value must be specified for"
                    + " '" + name + "'");
        } else if (normVal.length() > maxLen) {
            throw new IllegalArgumentException("The value specified for"
                    + " '" + name + "' was too long. It must not exceed"
                    + " " + maxLen + " characters.");
        }
        return normVal;
    }

    /**
     * Checks that the given value's normalized form is one of the allowed
     * values.
     *
     * @param name the name of the property being checked, for error reporting.
     * @param value the value.
     * @param validValues the allowed values.
     * @return the normalized value.
     * @throws IllegalArgumentException if the normalized value is null,
     *         zero-length, or not one of the allowed values.
     */
    public static String validate(String name, String value, String[] validValues)
            throws IllegalArgumentException {
        String normVal = validate(name, value, Integer.MAX_VALUE);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < validValues.length; i++) {
            if (i > 0) {
                s.append(", ");
            }
            s.append("'");
            s.append(validValues[i]);
            s.append("'");
            if (normVal.equals(validValues[i])) return normVal;
        }
        throw new IllegalArgumentException("One of the following values must"
                + " be specified for '" + name + "': [ " + s.toString()
                + " ]");
    }

    public static String validate(String name, String value) throws IllegalArgumentException {
        return validate(name, value, Integer.MAX_VALUE);
    }

    public static String validateInt(String name, String value) throws IllegalArgumentException {
        String normVal = validate(name, value, Integer.MAX_VALUE);
        try {
            Integer.parseInt(normVal);
            return normVal;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-integer specified for '"
                    + name + "'");
        }
    }
}
