package jsonParser;

import java.util.List;

public class GlossDef {
    private String para;
    private List<String> glossSeeAlso;

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public List<String> getGlossSeeAlso() {
        return glossSeeAlso;
    }

    public void setGlossSeeAlso(List<String> glossSeeAlso) {
        this.glossSeeAlso = glossSeeAlso;
    }

    @Override
    public String toString() {
        return "GlossDef{" +
                "para='" + para + '\'' +
                ", glossSeeAlso=" + glossSeeAlso +
                '}';
    }
}
