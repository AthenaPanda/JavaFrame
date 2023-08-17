package dataset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DividePackage {

	public static List<Integer> dividePackage(Integer totalAmount, Integer totalPeople){
		List<Integer> amountList = new ArrayList<Integer>();
		Integer restAmount = totalAmount;
		Integer restPeople = totalPeople;
		Random random = new Random();
		for(int i = 0; i < totalPeople -1; i++) {
			int amount = random.nextInt(restAmount/restPeople *2 -1) +1;
			restAmount -= amount;
			restPeople--;
			amountList.add(amount);
		}
		amountList.add(restAmount);
		return amountList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> amountList = dividePackage(1000, 10);
		for(Integer amount: amountList) {
			System.out.println("½ð¶î£º " + new BigDecimal(amount).divide(new BigDecimal(100)));
		}
	}

}
