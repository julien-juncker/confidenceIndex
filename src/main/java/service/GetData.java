/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author 33685
 */
@WebService(serviceName = "GetData")
public class GetData {

    @EJB
    private src.GetData ejbRef;
    
    @WebMethod(operationName="getMessage")
    public String getMessage() {
        return ejbRef.getMessage();
    }
    
    @WebMethod(operationName="confindenceIndex")
    public String confindenceIndex(ArrayList<String> liste1){
        return ejbRef.confindenceIndex(liste1);
    }
}
