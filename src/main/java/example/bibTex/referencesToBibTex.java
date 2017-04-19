/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.io.IOException;

/**
 *
 * @author tiera
 */
public interface referencesToBibTex{ 
    
    String EndFile();

    void EndReference();

    void HederAndItsType(String heder, String type);

    void OneFieldAndItsType(String field, String type);
    
}
