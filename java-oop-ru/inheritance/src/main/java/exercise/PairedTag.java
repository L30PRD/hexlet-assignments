package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> children;

    public PairedTag(String value, Map<String, String> dictionary, String body, List<Tag> children) {
        super(value, dictionary);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String child = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());

        return "<" + super.getValue() + super.toString()
                + ">" + body + child + "</" + super.getValue() + ">";
    }


}
// END
