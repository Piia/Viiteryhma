/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viiteryhma.wanhat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jannejau
 */
public class MockDatabase {
    private static List<OldArticle> references = new ArrayList<>();
    
    public static void add(OldArticle article) {
        references.add(article);
    }
    
    public static List<OldArticle> getAll() {
        return references;
    }
    
    public static void reset() {
        references.clear();
    }
}
