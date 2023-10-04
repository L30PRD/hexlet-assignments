package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    public SingleTag(String value, Map<String, String> dictionary) {
        super(value, dictionary);
    }

    @Override
    public String toString() {
        return "<" + super.getValue() + super.toString() + ">";
    }
}
// END
