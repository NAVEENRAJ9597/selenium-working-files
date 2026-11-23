public class StringProcessor {
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public String reverse(int input) {
        if (input == 0) return null;
        return new StringBuilder(String.valueOf(input)).reverse().toString();
    }
}