package lesson5;

//Задача про склад.
//      производитель - склад - покупатель
//        произодитель делает 5 товаров.
//        покупатель хочет 5 товаров купить
//        склад помещает только 3 товара.
//        лимит склада нельзя превышать,
//        пока покупатель не заберет часть товара туда нельзя добавлять.


public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            store.put();
        }
    }
}

class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            store.get();
        }
    }
}

class Store {
    private int product = 0;

    public synchronized void get() {
        while (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар.");
        System.out.println("В складе осталось " + product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("В складе товаров " + product);
        notify();
    }
}

class MainT {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();


    }
}