package com.notariaberrospi.sgn.util;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MainPOI {
       
       public static void main(String[] args) {
             try {
                    XWPFDocument docx = new XWPFDocument(OPCPackage.open("H:\\UtilitariosSoft\\Caso02\\LUIS.docx"));
                    
                    List<XWPFParagraph> xwpfParagraphs = docx.getParagraphs();
                    Map<String, String> replacedMap = new HashMap<String, String>();
                    
                    replacedMap.put("[DIAAA]", "26");
                    replacedMap.put("[NUM_DIA]", "MUSICAL1");
                    replacedMap.put("[NUM_HORA]", "MUSICAL2");
                    replacedMap.put("[NUM_QUE]", "MUSICAL3");
                    replacedMap.put("[NUM_POR]", "MUSICAL5");

                    replacedMap.put("[INSTRUMENTO]", "MUSICAL4");
                    replacedMap.put("[DIAAAAAAA]", "26");
                    replacedMap.put("[MEEEEEES]", "04");
                    
                    replacedMap.put("[FLAG]", "MUSICAL6");
                    
                    replacedMap.put("[LUIS]", "ANGEL");
                    
                    MainPOI poiMain = new MainPOI();
                    poiMain.replaceElementInParagraphs(xwpfParagraphs, replacedMap);
                    
                    docx.write(new FileOutputStream("H:\\UtilitariosSoft\\Caso02\\output2.docx"));
             } catch (Exception e) {
                    e.printStackTrace();
             }
       }

       private void replaceElementInParagraphs(List<XWPFParagraph> xwpfParagraphs,
                    Map<String, String> replacedMap) throws Exception{
             System.out.println("parrafo inicial: ");
             for(int j=0; j<xwpfParagraphs.size(); j++){
                    XWPFParagraph xwpfParagraph = xwpfParagraphs.get(j);
                    System.out.println(getNiceLyFormattedXMLDocument(xwpfParagraph.getCTP().getDomNode()));
             }
             
             System.out.println("\n analisisss");
             
             for(int i=0; i<xwpfParagraphs.size(); i++){
                    XWPFParagraph xwpfParagraph = xwpfParagraphs.get(i);
                    
                    System.out.println("-------------- Inicio Parrafo ["+i+"]: " + xwpfParagraph.getCTP().getDomNode().getNodeName());
                    System.out.println("Nodo Padre: "+getNiceLyFormattedXMLDocument(xwpfParagraph.getCTP().getDomNode()));
                    
                    String cadenaEspecial = "";
                    
                    NodeList nodeListWR = xwpfParagraph.getCTP().getDomNode().getChildNodes();
                    
                    for(int t = 0; t < nodeListWR.getLength(); t++ ){                         
                           Node nodeWR = nodeListWR.item(t);

                           if(nodeWR != null){
                                  System.out.println("nodeWR nodeName: \""+nodeWR.getNodeName() + "\" NodeType: \""+nodeWR.getNodeType()+"\"");
                                  if(nodeWR.getNodeName().equals("w:r")){
                                        NodeList nodeList = nodeWR.getChildNodes();
                                        
                                        Node nodeWT = null;
                                        if(nodeList != null && nodeList.getLength() > 0){
                                               for(int m=0; m<nodeList.getLength(); m++){
                                                      nodeWT = nodeList.item(m);
                                                      if(nodeWT.getNodeName().equals("w:t")){
                                                            break;
                                                      }
                                               }
                                        }
                                        
                                        if(nodeWT != null){
                                               System.out.println("Inicio nodeWT nodeName ["+t+"]: \""+ nodeWT.getNodeName() + "\" NodeType: \""+nodeWT.getNodeType()+"\"");
                                               String nodeTextValue = getTextValue(nodeWT);
                                               System.out.println("valor node: \""+nodeTextValue+"\"");

                                               if (cadenaEspecial.isEmpty() && !nodeTextValue.isEmpty() && nodeTextValue.contains("[") && !nodeTextValue.contains("]")) {
                                                      cadenaEspecial = cadenaEspecial + nodeTextValue;
                                                      
                                                      nodeWT.getParentNode().removeChild(nodeWT);
                                                      
                                                      System.out.println("Fin nodeWT ["+t+"]: "+ nodeWT.getNodeName());
                                                      continue;
                                               }

                                               if(cadenaEspecial.isEmpty()){
                                                      for (Map.Entry<String, String> entry : replacedMap.entrySet()) {
                                                            if(!nodeTextValue.isEmpty() && nodeTextValue.contains(entry.getKey())) {
                                                                   nodeTextValue = nodeTextValue.replace(entry.getKey(), entry.getValue());
                                                            }
                                                      }
                                                      
                                                      setTextValue(nodeWT, nodeTextValue);
                                                      
                                               }else {
                                                      cadenaEspecial = cadenaEspecial + nodeTextValue;

                                                      nodeWT.getParentNode().removeChild(nodeWT);
                                                      System.out.println("cadena especial: \""+cadenaEspecial+"\"");

                                                      boolean par = true;
                                                      for(int p=0; p<cadenaEspecial.length(); p++){
                                                            if('[' == cadenaEspecial.charAt(p)){
                                                                   par = false;
                                                                   for(int k = (p+1); k<cadenaEspecial.length(); k++){
                                                                          if(']' == cadenaEspecial.charAt(k)){
                                                                                 p = k + 1;
                                                                                 par = true;
                                                                                 break;
                                                                          }
                                                                   }
                                                            }
                                                      }
                                                      
                                                      if(par){
                                                             System.out.println("INICIO INSERTAR Y UPDATE");
                                                            System.out.println("Nodo Old: "+getNiceLyFormattedXMLDocument(nodeWT));

                                                            Node nextNode = null;
                                                            for(int k = (t+1); k<nodeListWR.getLength(); k++){
                                                                   Node nodeWRTemp = nodeListWR.item(k);
                                                                   
                                                                   Node nodeWTTemp = nodeWRTemp.getFirstChild();
                                                                   
                                                                   if(nodeWTTemp != null){
                                                                          nextNode = nodeWTTemp.getParentNode();
                                                                          t = k;
                                                                          break;
                                                                   }
                                                            }
                                                            
                                                            for (Map.Entry<String, String> entry : replacedMap.entrySet()) {
                                                                   if(cadenaEspecial.contains(entry.getKey())) {
                                                                          cadenaEspecial = cadenaEspecial.replace(entry.getKey(), entry.getValue());
                                                                   }
                                                             }
                                                            
                                                            XWPFRun run = xwpfParagraph.createRun();
                                               run.setText(cadenaEspecial);
                                               
                                               System.out.println("getCTR Nuevo: "+getNiceLyFormattedXMLDocument(run.getCTR().getDomNode()));
                                               
                                               System.out.println("Nodo Next: "+getNiceLyFormattedXMLDocument(nextNode));
                                                            
                                                             xwpfParagraph.getCTP().getDomNode().insertBefore(run.getCTR().getDomNode(), nextNode);
                                                            
                                                            cadenaEspecial = "";

                                                      }
                                               }
                                               
                                               System.out.println("Fin nodeWT ["+t+"]: "+ nodeWT.getNodeName());
                                        }
                                  }
                           }else{
                                  System.out.println("node es nulo");
                           }
                    }
                    
                    System.out.println("-------------- Fin Parrafo ["+i+"] " + xwpfParagraph.getCTP().getDomNode().getNodeName());
             }
             
             System.out.println("parrafo Final: ");
             for(int f=0; f<xwpfParagraphs.size(); f++){
                    XWPFParagraph xwpfParagraph = xwpfParagraphs.get(f);
                    System.out.println(getNiceLyFormattedXMLDocument(xwpfParagraph.getCTP().getDomNode()));
             }
       }
       
       private String getTextValue(Node node) {
             StringBuffer textValue = new StringBuffer("");
             
           for (int i = 0; i < node.getChildNodes().getLength(); i ++) {
              Node c = node.getChildNodes().item(i);
              System.out.println("NodeType y nodeName del hijo de nodeWT: \""+c.getNodeType()+"\", \""+c.getNodeName()+"\" obteniendo valor node: \""+c.getNodeValue()+"\"");
              if (c.getNodeType() == Node.TEXT_NODE) {
                    textValue.append(c.getNodeValue());
              }
           }
           
           return textValue.toString();
       }
       
       private void setTextValue(Node node, String newValue) {
           for (int i = 0; i < node.getChildNodes().getLength(); i ++) {
              Node c = node.getChildNodes().item(i);
              if (c.getNodeType() == Node.TEXT_NODE) {
                    c.setNodeValue(newValue);
              }
           }
       }
       
       private String getNiceLyFormattedXMLDocument(Node doc) {
             String result = "";
             try{
                    TransformerFactory tf = TransformerFactory.newInstance();
                 Transformer transformer = tf.newTransformer();
                 transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                 transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                 transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
             
                 Writer stringWriter = new StringWriter();
                 StreamResult streamResult = new StreamResult(stringWriter);
                 transformer.transform(new DOMSource(doc), streamResult);
                 result = stringWriter.toString();
             }catch(Exception e){
                    e.printStackTrace();
             }
           
        
           return result;
       }
}
