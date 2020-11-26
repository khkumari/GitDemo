package jsonParser;

public class GlossList {
    private GlossEntry glossEntry;

    public GlossEntry getGlossEntry() {
        return glossEntry;
    }

    public void setGlossEntry(GlossEntry glossEntry) {
        this.glossEntry = glossEntry;
    }

    @Override
    public String toString() {
        return "GlossList{" +
                "glossEntry=" + glossEntry +
                '}';
    }
}
