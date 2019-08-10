package lesson5;

public class Main {
    public static void main(String[] args) {
        // пример создание потока наследованием от Thread
//        MyThread t1 = new MyThread("t1");
//        MyThread t2 = new MyThread("t2");
//
//        t1.start();
//        t2.start();
//
//        t1.run();
//        t2.run();

        // пример создание потока наследованием реализацией интерфейса Runnable
//        Thread t1 = new Thread(new MyRunnable("t1"));
//        Thread t2 = new Thread(new MyRunnable("t2"));
//
//        t1.start();
//        t2.start();

        // пример создание потока анонимным классом.
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i+0);
//                }
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i+10);
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();


//  пример создание потока лямда выражением.
//        Runnable runnable1 = ()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//        };
//
//        Thread t1 = new Thread(runnable1);
//        Thread t2 = new Thread(runnable1);
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i+0);
//            }
//        });
//
//        Thread t2 = new Thread(()->{
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i+10);
//                }
//        });
//
//        t1.start();
//        t2.start();

        //  пример создание потока лямда выражением.
//        Thread t1 = new Thread(()->{
//            System.out.println(1);
//        });
//
//        Thread t2 = new Thread(()->{
//            System.out.println(2);
//        });
//
//        t1.start();
//        t2.start();
//
//        System.out.println(3);


        //  про join
        // использовать join и попросить наш основной поток подождать
        // завершение потока t1 и только после его завершения продолжить работу

//        Thread t1 = new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                    System.out.println(i);
//                }
//        });
//
//        t1.start();
//
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("End");


        // синхронизация по методу  и по объекту
//        Counter counter = new Counter();
//
//        Thread t1 = new Thread(()->{
//            for (int i = 0; i <1000000 ; i++) {
//                synchronized (counter){
//                    counter.inc();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(()->{
//            for (int i = 0; i <1000000 ; i++) {
//                synchronized (counter){
//                    counter.dec();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(counter.getC());


//        Задача про банкомат .
//        В банкомате есть 100 рублей и
//        3 человека хотят снять по 50 рублей.
//        Банкомат с 3 точками вывода денег.

//        ATM atm = new ATM(100);
//        Thread t1 = new Thread(()->{
//            atm.take(50,"user1");
//        });
//
//        Thread t2 = new Thread(()->{
//            atm.take(50,"user2");
//        });
//
//        Thread t3 = new Thread(()->{
//            atm.take(50,"user3");
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        atm.info();


        //        про завершение программы при окончании основного потока
        //  демон потоки завершаются если не осталось обычных потоков, и программа завершится
        Thread t1 = new Thread(new Runnable() {
            int seconds = 0;
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds++;
                    System.out.println("time: " + seconds);
                }
            }
        });

        t1.setDaemon(true);
        t1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end ");
    }
}
