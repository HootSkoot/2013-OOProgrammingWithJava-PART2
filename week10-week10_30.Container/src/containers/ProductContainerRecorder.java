/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Michael
 */
public class ProductContainerRecorder extends ProductContainer{
    private ContainerHistory history;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        this.history = new ContainerHistory();
        addToTheContainer(initialVolume);
    }
    
    public String history(){
        return history.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount); //To change body of generated methods, choose Tools | Templates.
        history.add(getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double prevVolume = getVolume();
        super.takeFromTheContainer(amount);
        history.add(super.getVolume());
        return prevVolume - getVolume();
    }
    
    public void  printAnalysis(){
        System.out.println("Product: " + getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + history.maxValue());
        System.out.println("Smallest product amount: " + history.minValue());
        System.out.println("Average: " + history.average());
        System.out.println("Greatest change: " + history.greatestFluctuation());
        System.out.println("Variance: " + history.variance());
    }
}
