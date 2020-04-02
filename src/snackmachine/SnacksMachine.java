package snackmachine;
import java.util.List;

public interface SnacksMachine {
	public double selectItem(SnackType item);
	public void insertMoney(Money money);
        public void reset();
        public double getMoneyInTransaction();
        public double getChange();
        public String buy();
        public double getMoneyInMachine();
	public int getQuntity(SnackType item);

	}
