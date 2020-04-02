package snackmachine;

import java.util.ArrayList;
import java.util.List;

public class SnackMachineImpl implements SnacksMachine{
	private List<Double> moneyInTransaction = new ArrayList<Double>();
	private Inventory<SnackType> itemInventory = new Inventory<SnackType>();
	private long totalSales;
	private SnackType currentItem;
	private double currentBalance;
        public double moneyInMachine;

	public SnackMachineImpl() {
		initialize();
	}
        
	private void initialize() {
		
		for (SnackType i : SnackType.values()) {
			itemInventory.put(i, 10);
		}
                    
	}
        
	@Override
	public double selectItem(SnackType item) {
		if (itemInventory.hasItem(item)) {
			currentItem = item;
			return currentItem.getPrice()*0.01;
		}
		return 0;
	}

	@Override
	public void insertMoney(Money money) {
		currentBalance = currentBalance + money.getDenomination();
		moneyInTransaction.add(money.getDenomination());     
	}
        
        @Override
        public double getMoneyInTransaction(){
            return currentBalance*0.01;
        }
        
        

        @Override
        public double getChange(){
            if(getMoneyInTransaction() >= selectItem(currentItem)){
                return getMoneyInTransaction() - selectItem(currentItem);
            }
            else{
                return -1;
            }
        }
        
        @Override
        public String buy(){
            if(!moneyInTransaction.isEmpty()){
                if(currentItem != null){
                    if(itemInventory.hasItem(currentItem)){
                        if(currentBalance >= currentItem.getPrice())
                            if(moneyInMachine >= getChange()){
                                itemInventory.deduct(currentItem);
                                moneyInMachine += getMoneyInTransaction()-getChange();
                                return "Done"; 
                            }
                            else{
                                return "No money inside the machine to return the change";
                            }
                        else 
                            return "Please inert more money or choose another item";
                    }
                    else 
                        return "This item is not available. Please choose another item";
                
                }
                else 
                    return "Please Choose an Item";
            }
            else
                return "Please insert a Money";
        }
        
        
        @Override
        public double getMoneyInMachine(){
            return moneyInMachine;
        }
        
        @Override
        public void reset(){
            moneyInTransaction.clear();
            currentBalance = 0;
            currentItem = null;
        }
        
        @Override
	public int getQuntity(SnackType item){
            return itemInventory.getQuantity(item);
        }

}
