package nbparsexhtml;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List Listadocenti;

    public Parser() {
        Listadocenti = new ArrayList();
    }

    
    public List parseDocument(String filename, String gg)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Docente doc;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 2; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                doc = getLink(element);
                   if (doc.getGiorno().equals(gg)) {
                    Listadocenti.add(doc);
                    System.out.println(doc.toString());
                }
            }
        }
        return Listadocenti;
    }
  
    private Docente getLink(Element element) {
        Docente doc;
        NodeList nodelist;
        int codice=0;
        String docente="", giorno="", ora="";
        Element td;
      nodelist = element.getElementsByTagName("td");
    if (nodelist != null && nodelist.getLength() > 0) {
        for (int i = 0; i < nodelist.getLength(); i++) {
        td = (Element) nodelist.item(i);
        if(td!=null){
        if(codice==0){
        codice=Integer.parseInt(getTextValue(td));
        }else if(docente.equals("")){
        docente=getTextValue(td);
        }else if(giorno.equals("")){
        giorno=getTextValue(td);
        }else if(ora.equals("")){
        ora=getTextValue(td);
}
}
}
}
            doc = new Docente(codice,docente,giorno,ora);
        
        return doc;
    }
    

    // restituisce il valore testuale dell’elemento figlio specificato
  private String getTextValue(Element element) {
String value = null;
if (element != null ) {
Node el = element.getFirstChild();
if(el!=null){
value = el.getNodeValue();
}
}
return value;
}

}
