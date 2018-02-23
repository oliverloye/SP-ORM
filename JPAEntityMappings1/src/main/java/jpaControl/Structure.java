/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Structure {
    
    public static void main(String[] args) {
        
        HashMap puProperties = new HashMap();
        
        puProperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        puProperties.put("javax.persistence.sql-load-script-source", "scripts/data.sql");
        Persistence.generateSchema("jpaEM1PU", puProperties);
        
        puProperties.remove("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        //puProperties.remove("javax.persistence.sql-load-script-source", "scripts/data.sql");
        Persistence.generateSchema("jpaEM1PU", puProperties);
    }
}
