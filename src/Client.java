//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//interface DocumentElement
//{
//    String render();
//}
//
//class TextElement implements DocumentElement
//{
//    private String text;
//    public TextElement(String text)
//    {
//        this.text = text;
//    }
//    @Override
//    public String render()
//    {
//        return text;
//    }
//}
//
//class ImageElement implements DocumentElement
//{
//    private String image;
//    public ImageElement(String image)
//    {
//        this.image = image;
//    }
//    @Override
//    public String render()
//    {
//        return image;
//    }
//}
//
//class NewLineElement implements DocumentElement
//{
//    @Override
//    public String render()
//    {
//        return "\n";
//    }
//}
//
//class TabSpaceElement implements DocumentElement
//{
//    @Override
//    public String render()
//    {
//        return "\t";
//    }
//}
//
//class Document
//{
//    private List<DocumentElement> elements;
//    public Document()
//    {
//        elements = new ArrayList<>();
//    }
//    void addElement(DocumentElement e)
//    {
//        elements.add(e);
//    }
//    String render()
//    {
//        StringBuilder sb = new StringBuilder();
//        for (DocumentElement e : elements)
//        {
//            sb.append(e.render());
//        }
//        return sb.toString();
//    }
//}
//
//interface Persistence
//{
//    void save(String data);
//}
//
//class FileStorage implements Persistence
//{
//    @Override
//    public void save(String data)
//    {
//        try{
//            FileWriter fw = new FileWriter("document.txt");
//            fw.write(data);
//            fw.close();
//            System.out.println("Document has been saved to document.txt");
//        }
//        catch (IOException e)
//        {
//            System.out.println("Error: Unable to open file for writing.");
//        }
//    }
//}
//
//class DBStorage implements Persistence
//{
//    @Override
//    public void save(String data)
//    {
//        System.out.println("DB has been saved to Database");
//    }
//}
//
//class DocumentEditor
//{
//    Document document;
//    Persistence persistence;
//    String renderedDocument;
//    public DocumentEditor(Document document, Persistence persistence)
//    {
//        renderedDocument = "";
//        this.document = document;
//        this.persistence = persistence;
//    }
//    public void addText(String text)
//    {
//        document.addElement(new TextElement(text));
//    }
//    public void addImage(String image)
//    {
//        document.addElement(new ImageElement(image));
//    }
//    public void addNewLine()
//    {
//        document.addElement(new NewLineElement());
//    }
//    public void addTabSpace()
//    {
//        document.addElement(new TabSpaceElement());
//    }
//    String renderDocument()
//    {
//        if(renderedDocument.isEmpty())
//        {
//            renderedDocument = document.render();
//        }
//        return renderedDocument;
//    }
//    void saveDocument()
//    {
//        persistence.save(renderDocument());
//    }
//}
//
//
//public class Client
//{
//    public static void main(String[] args)
//    {
//        Document document = new Document();
//        Persistence persistence = new FileStorage();
//
//        DocumentEditor editor = new DocumentEditor(document, persistence);
//
//        editor.addText("Hello World");
//        editor.addNewLine();
//        editor.addTabSpace();
//        editor.addImage("Document.jpg");
//        editor.addNewLine();
//        editor.addText("This is a real-world document editor example");
//        editor.addTabSpace();
//        editor.addText("...");
//        editor.addNewLine();
//        System.out.println(editor.renderDocument());
//        editor.saveDocument();
//    }
//}

// Better one in which tried to apply the SOLID principles more intactly
//

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement
{
    String render();
}

class TextElement implements DocumentElement
{
    private String text;
    public TextElement(String text)
    {
        this.text = text;
    }
    @Override
    public String render()
    {
        return text;
    }
}

class ImageElement implements DocumentElement
{
    private String image;
    public ImageElement(String image)
    {
        this.image = image;
    }
    @Override
    public String render()
    {
        return image;
    }
}

class NewLineElement implements DocumentElement
{
    @Override
    public String render()
    {
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement
{
    @Override
    public String render()
    {
        return "\t";
    }
}

class Document
{
    private List<DocumentElement> elements;
    public Document()
    {
        elements = new ArrayList<>();
    }
    void addElement(DocumentElement e)
    {
        elements.add(e);
    }

    public List<DocumentElement> getElements()
    {
        return elements;
    }


}
class DocumentRenderer
{
    Document document;
    String renderedDocument;
    DocumentRenderer(Document document)
    {
        this.document = document;
        renderedDocument = "";
    }
    void render()
    {
        StringBuilder sb = new StringBuilder();
        for (DocumentElement e : document.getElements())
        {
            sb.append(e.render());
        }
        renderedDocument = sb.toString();
    }
    public String getRenderedDocument()
    {
        if(renderedDocument.isEmpty())
        {
            render();
        }
        return renderedDocument;
    }
}

interface Persistence
{
    void save(String data);
}

class FileStorage implements Persistence
{
    @Override
    public void save(String data)
    {
        try{
            FileWriter fw = new FileWriter("document.txt");
            fw.write(data);
            fw.close();
            System.out.println("Document has been saved to document.txt");
        }
        catch (IOException e)
        {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

class DBStorage implements Persistence
{
    @Override
    public void save(String data)
    {
        System.out.println("DB has been saved to Database");
    }
}

class DocumentEditor
{
    Document document;
    public DocumentEditor(Document document)
    {
        this.document = document;
    }
    public void addText(String text)
    {
        document.addElement(new TextElement(text));
    }
    public void addImage(String image)
    {
        document.addElement(new ImageElement(image));
    }
    public void addNewLine()
    {
        document.addElement(new NewLineElement());
    }
    public void addTabSpace()
    {
        document.addElement(new TabSpaceElement());
    }
}


public class Client
{
    public static void main(String[] args)
    {
        Document document = new Document();
        Persistence persistence = new FileStorage();
        DocumentEditor editor = new DocumentEditor(document);
        DocumentRenderer documentRenderer = new DocumentRenderer(document);

        editor.addText("Hello World");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addImage("Document.jpg");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example");
        editor.addTabSpace();
        editor.addText("...");
        editor.addNewLine();
        System.out.println(documentRenderer.getRenderedDocument());
        persistence.save(documentRenderer.getRenderedDocument());
    }
}