package com.hpfs.distillery.retailer.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.hpfs.distillery.retailer.model.TblBarcodeM; 

public class XmlReader {
	
	public static List<TblBarcodeM> readXMLFileData() {
		
		 List<TblBarcodeM> list = new ArrayList<>();
	try {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse (new File("c:\\temp\\input.xml"));

        // normalize text representation
        doc.getDocumentElement ().normalize ();
        System.out.println ("Root element of the doc is " + 
             doc.getDocumentElement().getNodeName());


        NodeList listOfPersons = doc.getElementsByTagName("parent");
        int totalPersons = listOfPersons.getLength();
        System.out.println("Total no of barcode : " + totalPersons);

        for(int s=0; s<listOfPersons.getLength() ; s++){
            Node firstPersonNode = listOfPersons.item(s);
            if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){
            	TblBarcodeM m = new TblBarcodeM();
                Element firstPersonElement = (Element)firstPersonNode;

                //-------
               /* NodeList id = firstPersonElement.getElementsByTagName("id");
                Element idElement = (Element)id.item(0);
                NodeList idList = idElement.getChildNodes();
                if(idList!=null && idList.item(0)!=null) {
                System.out.println("id  : " + 
                       ((Node)idList.item(0)).getNodeValue().trim());
                }*/

                //-------
                NodeList userName = firstPersonElement.getElementsByTagName("username");
                Element userNameElement = (Element)userName.item(0);

                NodeList userNameList = userNameElement.getChildNodes();
                if(userNameList!=null && userNameList.item(0)!=null) {
                	m.setUserName(((Node)userNameList.item(0)).getNodeValue().trim());
                System.out.println("username : " + 
                       ((Node)userNameList.item(0)).getNodeValue().trim());
                }
                
              //-------
                NodeList mobilenumber = firstPersonElement.getElementsByTagName("mobilenumber");
                Element mobilenumberElement = (Element)mobilenumber.item(0);

                NodeList mobilenumberList = mobilenumberElement.getChildNodes();
                if(mobilenumberList!=null && mobilenumberList.item(0)!=null) {
                	m.setMobileNumber(((Node)mobilenumberList.item(0)).getNodeValue().trim());
                System.out.println("mobilenumber : " + 
                       ((Node)mobilenumberList.item(0)).getNodeValue().trim());
                }
                
              //-------
                NodeList barcodenumber = firstPersonElement.getElementsByTagName("barcodenumber");
                Element barcodenumberElement = (Element)barcodenumber.item(0);
                NodeList barcodenumberList = barcodenumberElement.getChildNodes();
                if(barcodenumberList!=null && barcodenumberList.item(0)!=null) {
                	m.setBarcodeNumber(((Node)barcodenumberList.item(0)).getNodeValue().trim());
                System.out.println("barcodenumber  : " + 
                       ((Node)barcodenumberList.item(0)).getNodeValue().trim());
                }

                //-------
                NodeList itemname = firstPersonElement.getElementsByTagName("itemname");
                Element itemnameElement = (Element)itemname.item(0);

                NodeList itemnameList = itemnameElement.getChildNodes();
                if(itemnameList!=null && itemnameList.item(0)!=null) {
                	m.setItemName(((Node)itemnameList.item(0)).getNodeValue().trim());
                System.out.println("itemname : " + 
                       ((Node)itemnameList.item(0)).getNodeValue().trim());
                }
                
              //-------
                NodeList size = firstPersonElement.getElementsByTagName("size");
                Element sizeElement = (Element)size.item(0);

                NodeList sizeList = sizeElement.getChildNodes();
                if(sizeList!=null && sizeList.item(0)!=null) {
                	m.setSize(((Node)sizeList.item(0)).getNodeValue().trim());
                System.out.println("size : " + 
                       ((Node)sizeList.item(0)).getNodeValue().trim());
                }
                
                //-------
                NodeList price = firstPersonElement.getElementsByTagName("price");
                Element priceElement = (Element)price.item(0);
                NodeList priceList = priceElement.getChildNodes();
                if(priceList!=null && priceList.item(0)!=null) {
                	m.setPrice(((Node)priceList.item(0)).getNodeValue().trim());
                System.out.println("price  : " + 
                       ((Node)priceList.item(0)).getNodeValue().trim());
                }

                //-------
                NodeList offer = firstPersonElement.getElementsByTagName("offer");
                Element offerElement = (Element)offer.item(0);

                NodeList offerList = offerElement.getChildNodes();
                if(offerList!=null && offerList.item(0)!=null) {
                	m.setOffer(((Node)offerList.item(0)).getNodeValue().trim());
                System.out.println("offer : " + 
                       ((Node)offerList.item(0)).getNodeValue().trim());
                }
                
              //-------
                NodeList storename = firstPersonElement.getElementsByTagName("storename");
                Element storenameElement = (Element)storename.item(0);

                NodeList storenameList = storenameElement.getChildNodes();
                if(storenameList!=null && storenameList.item(0)!=null) {
                	m.setStoreName(((Node)storenameList.item(0)).getNodeValue().trim());
                System.out.println("storename : " + 
                       ((Node)storenameList.item(0)).getNodeValue().trim());
                }
                
              //-------
                NodeList location = firstPersonElement.getElementsByTagName("location");
                Element locationElement = (Element)location.item(0);
                NodeList locationList = locationElement.getChildNodes();
                if(locationList!=null && locationList.item(0)!=null) {
                	m.setLocation(((Node)locationList.item(0)).getNodeValue().trim());
                System.out.println("location  : " + 
                       ((Node)locationList.item(0)).getNodeValue().trim());
                }

                //-------
                NodeList offerstoavail = firstPersonElement.getElementsByTagName("offerstoavail");
                Element offerstoavailElement = (Element)offerstoavail.item(0);

                NodeList offerstoavailList = offerstoavailElement.getChildNodes();
                if(offerstoavailList!=null && offerstoavailList.item(0)!=null) {
                	m.setOfferToAvail(((Node)offerstoavailList.item(0)).getNodeValue().trim());
                System.out.println("offerstoavail : " + 
                       ((Node)offerstoavailList.item(0)).getNodeValue().trim());
                }
                
                list.add(m);
            }//end of if clause

        }//end of for loop with s var
    }catch (SAXParseException err) {
    System.out.println ("** Parsing error" + ", line " 
         + err.getLineNumber () + ", uri " + err.getSystemId ());
    System.out.println(" " + err.getMessage ());

    }catch (SAXException e) {
    Exception x = e.getException ();
    ((x == null) ? e : x).printStackTrace ();

    }catch (Throwable t) {
    t.printStackTrace ();
    }
	return list;
	
	}

}
