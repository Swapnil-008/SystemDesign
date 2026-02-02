
// Adapter Design Pattern:
// - It converts two incompatible interfaces to work together by converting one interface to another expected by the client
// - Wrapper that makes things compatible
// - Target: Interface expects to client
// - Adaptee: Existing incompatible class
// - Adapter: Converts adaptee to target
// - Client: Uses target interface

// 1. Target interface expected by the client
interface Reports
{
    // now takes the raw data string and returns JSON
    String getJsonData(String data);
}

// 2. Adaptee: (to whom adapter have to adapt) provides XML data from a raw input
class XmlDataProvider
{
    // Expect data in "name:id" format (e.g. "Alice:42")
    String getXmlData(String data)
    {
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id   = data.substring(sep + 1);
        // Build an XML representation
        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>"   + id   + "</id>"
                + "</user>";
    }
}

// 3. Adapter: implements Reports by converting XML → JSON
class XmlDataProviderAdapter implements Reports
{
    private final XmlDataProvider xmlProvider;
    public XmlDataProviderAdapter(XmlDataProvider provider)
    {
        this.xmlProvider = provider;
    }
    public String getJsonData(String data)
    {
        // 1. Get XML from the adaptee
        String xml = xmlProvider.getXmlData(data);

        // 2. Naïvely parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id   = xml.substring(startId, endId);

        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}

// 4. Client code works only with Reports
class Client2
{
    public void getReport(Reports report, String rawData)
    {
        System.out.println("Processed JSON: " + report.getJsonData(rawData));
    }
}

public class AdapterDesignPattern
{
    public static void main(String[] args)
    {
        // 1. Create the adaptee
        XmlDataProvider xmlProv = new XmlDataProvider();

        // 2. Make our adapter and passed the adaptee
        Reports adapter = new XmlDataProviderAdapter(xmlProv);

        // 3. Give it some raw data
        String rawData = "Alice:42";

        // 4. Client prints the JSON
        Client2 client = new Client2();

        client.getReport(adapter, rawData);
        // → Processed JSON: {"name":"Alice", "id":42}
    }
}