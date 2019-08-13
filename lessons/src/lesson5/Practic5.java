package lesson5;

import java.util.Arrays;

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 *
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 *
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
 *
 * Пример деления одного массива на два:
 *
 * System.arraycopy(arr, 0, a1, 0, h);
 * System.arraycopy(arr, h, a2, 0, h);
 *
 * Пример обратной склейки:
 *
 * System.arraycopy(a1, 0, arr, 0, h);
 * System.arraycopy(a2, 0, arr, h, h);
 *
 * Примечание:
 * System.arraycopy() – копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 *
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 *
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */

public class Practic5 {

    static final int size = 10000000;
    static final int halfSize = size / 2;

    static void fillArray(float[] arr)
    {
        long startTime = System.currentTimeMillis();

        for (int i=0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - startTime);
        getSum(arr);
    }

    static void fillArray2(float[] arr) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        float[] arrHalf1 = new float[halfSize];
        float[] arrHalf2 = new float[halfSize];

        System.arraycopy(arr, 0, arrHalf1, 0, halfSize);
        System.arraycopy(arr, halfSize, arrHalf2, 0, halfSize);

        Thread t1 = calcInTread(arrHalf1, 0);
        Thread t2 = calcInTread(arrHalf2, halfSize);

        t1.join();
        t2.join();

        System.arraycopy(arrHalf1, 0, arr, 0, halfSize);
        System.arraycopy(arrHalf2, 0, arr, halfSize, halfSize);

        System.out.println(System.currentTimeMillis() - startTime);
        getSum(arr);
    }

    private static Thread calcInTread(float[] arr, int num) {
        Thread t = new Thread(()->{
            int _num = num;
            for (int i=0; i < arr.length; i++, _num++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + _num / 5) * Math.cos(0.2f + _num / 5) * Math.cos(0.4f + _num / 2));
            }
        });

        t.start();
        return t;
    }

    private static void getSum(float[] arr) {
        float sum = 0;
        for (float val: arr) {
            sum += val;
        }
        System.out.println("The sum is " + sum);
    }

    public static void main(String[] args) {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] arr2 = arr.clone();

        fillArray(arr);

        try {
            fillArray2(arr2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * out:
 * 1711
 * The sum is 0.95204055
 * 825
 * The sum is 0.95204055
 */

