package jsonParser;

public class GlossEntry {
    private String id;
    private String sortAs;
    private String glossTerm;
    private String acronym;
    private String abbrev;
    private String glossSee;
    private GlossDef glossDef;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSortAs() {
        return sortAs;
    }

    public void setSortAs(String sortAs) {
        this.sortAs = sortAs;
    }

    public String getGlossTerm() {
        return glossTerm;
    }

    public void setGlossTerm(String glossTerm) {
        this.glossTerm = glossTerm;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getGlossSee() {
        return glossSee;
    }

    public void setGlossSee(String glossSee) {
        this.glossSee = glossSee;
    }

    public GlossDef getGlossDef() {
        return glossDef;
    }

    public void setGlossDef(GlossDef glossDef) {
        this.glossDef = glossDef;
    }

    @Override
    public String toString() {
        return "GlossEntry{" +
                "id='" + id + '\'' +
                ", sortAs='" + sortAs + '\'' +
                ", glossTerm='" + glossTerm + '\'' +
                ", acronym='" + acronym + '\'' +
                ", abbrev='" + abbrev + '\'' +
                ", glossSee='" + glossSee + '\'' +
                ", glossDef=" + glossDef +
                '}';
    }
}
