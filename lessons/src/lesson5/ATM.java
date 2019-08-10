package lesson5;

// Задача про банкомат . в банкомате есть 100 рублей и
//        3 человека хотят снять по 50 рублей.
//        Банкомат с 3 точками вывода денег.

public class ATM {
    int money;

    public ATM(int money) {
        this.money = money;
    }

    public synchronized void take(int amount, String user){
        if(money >= amount){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println(user+" получил "+ amount);
        }else {
            System.out.println(user+" не смог получить денег");
        }
    }

    public void info(){
        System.out.println("ATM: " + money);
    }
}
