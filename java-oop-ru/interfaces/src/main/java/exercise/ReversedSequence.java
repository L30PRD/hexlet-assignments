package exercise;

// BEGIN
class ReversedSequence implements CharSequence {

    String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    public String getReverse(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();
    }

    @Override
     public String toString() {
         return getReverse(text);
     }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return getReverse(text).charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (end > text.length()) {
            end = text.length();
        }
        if (start < 0) {
            start = 0;
        }
        return getReverse(text).subSequence(start, end);
    }
}
// END
