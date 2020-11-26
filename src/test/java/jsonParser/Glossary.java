package jsonParser;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement(namespace = "glossary")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Glossary {
 //   @JacksonXmlProperty(localName = "GlossDiv")
   private GlossDiv glossDiv;
   private String title;

    public GlossDiv getGlossDiv() {
        return glossDiv;
    }

    public void setGlossDiv(GlossDiv glossDiv) {
        this.glossDiv = glossDiv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Glossary{" +
                "glossDiv=" + glossDiv +
                ", title='" + title + '\'' +
                '}';
    }
}
