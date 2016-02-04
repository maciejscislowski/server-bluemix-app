package it.scislowski.bluemix.server.domain;

import lombok.Data;
import org.ektorp.support.CouchDbDocument;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maciej.Scislowski@gmail.com
 */
@Data
@XmlRootElement
public class User extends CouchDbDocument {

    private String username;

}
