
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Storehouse {
    private Map<String, Integer> storeHouse;
    private Map<String, Integer> productStocks;

    public Storehouse() {
        storeHouse = new HashMap<String, Integer>();
        productStocks = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock){
        storeHouse.put(product, price);
        productStocks.put(product, stock);
    }
    
    public int price(String product){
        if (storeHouse.get(product) == null) {
            return -99;
        }
        return storeHouse.get(product);
    }
    
    public int stock(String product){
        if (productStocks.get(product) == null) {
            return 0;
        }
        return productStocks.get(product);
    }
    
    public boolean take(String product){
        if (productStocks.get(product) == null) {
            return false;
        }
        if (productStocks.get(product) > 0) {
            productStocks.put(product, productStocks.get(product) - 1);
            return true;
        }
        return false;
        
    }
    
    public Set<String> products(){
        return storeHouse.keySet();
    }
}
