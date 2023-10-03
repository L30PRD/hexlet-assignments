package exercise;

// BEGIN
class  LabelTag implements TagInterface {
    String tag;
    TagInterface inputTag;

    public LabelTag(String tag, TagInterface inputTag) {
        this.tag = tag;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return "<label>" + this.tag + inputTag.render() + "</label>";
    }
}
// END
