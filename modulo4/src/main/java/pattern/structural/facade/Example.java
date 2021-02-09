/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structural.facade;

/**
 *
 * @author abraham
 */
public class Example {

    Connection con;

    public Example() throws Exception {
        FacadeExample fe = new FacadeExample();
        this.con = fe.getConnection("Connection String");
    }
}
