
package com.example.cityclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.cityclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SearchCities_QNAME = new QName("http://cityservice.example.com/", "searchCities");
    private final static QName _SearchCitiesResponse_QNAME = new QName("http://cityservice.example.com/", "searchCitiesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.cityclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchCitiesResponse }
     * 
     */
    public SearchCitiesResponse createSearchCitiesResponse() {
        return new SearchCitiesResponse();
    }

    /**
     * Create an instance of {@link SearchCities }
     * 
     */
    public SearchCities createSearchCities() {
        return new SearchCities();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cityservice.example.com/", name = "searchCities")
    public JAXBElement<SearchCities> createSearchCities(SearchCities value) {
        return new JAXBElement<SearchCities>(_SearchCities_QNAME, SearchCities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cityservice.example.com/", name = "searchCitiesResponse")
    public JAXBElement<SearchCitiesResponse> createSearchCitiesResponse(SearchCitiesResponse value) {
        return new JAXBElement<SearchCitiesResponse>(_SearchCitiesResponse_QNAME, SearchCitiesResponse.class, null, value);
    }

}
