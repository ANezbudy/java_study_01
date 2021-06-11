package Hash;

public class OurString {
    private static final char firstChar = ' ';
    private static final int numOfSymbols = 'z' - firstChar;

    private String value;
    private int ourHashCode;

    OurString (String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        ourHashCode = getHash(value);
    }

    public static int getHash(String string) {
        int p = 1;
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            result = result + (string.charAt(i) - firstChar) * p;
            p = p * numOfSymbols;
        }
        return result;
    }

    public int getOurHashCode() {
        return ourHashCode;
    }

    @Override
    public boolean equals(Object obj) {
        return ((OurString)obj).getOurHashCode() == getOurHashCode() && getValue().equals(((OurString)obj).getValue());
    }
}
