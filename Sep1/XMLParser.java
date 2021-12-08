import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;

public class XMLParser
{
  public static void toXML(Object obj, String filename)
  {
    XmlJsonParser xmlparser = new XmlJsonParser();
    File file = null;

    try
    {
      file = xmlparser.toXml(obj, filename);
    }
    catch (ParserException parserE)
    {
      parserE.printStackTrace();
    }

    System.out.println("XML Location: " + file.getAbsolutePath());
  }
}
