package backend.take.home.parameters;

/**
 * The Language enum.
 */
public enum Language {
    ENGLISH ("en"),
    RUSSIAN ("ru");

    private final String paramString;

    Language(String paramString) {
        this.paramString = paramString;
    }

    public String getParamString() {
        return paramString;
    }

    public static Language lookup(String language) {
        if (language == null)
            return null;

        // TODO: Handle more versions of input, for example, "en" and "english"
        // TODO: Handle arguments in Russian
        String trimmed = language.trim();
        for (Language l : Language.values()) {
            if (l.name().equalsIgnoreCase(trimmed)) {
                return l;
            }
        }
        return null;
    }
}