package jsonParser;

public class Main {

    private Glossary glossary;

    public Glossary getGlossary() {
        return glossary;
    }

    public void setGlossary(Glossary glossary) {
        this.glossary = glossary;
    }

    @Override
    public String toString() {
        return "Main{" +
                "glossary=" + glossary +
                '}';
    }
}
