package jsonParser;

public class GlossDiv {
    private String title;
    private GlossList glossList;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GlossList getGlossList() {
        return glossList;
    }

    public void setGlossList(GlossList glossList) {
        this.glossList = glossList;
    }

    @Override
    public String toString() {
        return "GlossDiv{" +
                "title='" + title + '\'' +
                ", glossList=" + glossList +
                '}';
    }
}
