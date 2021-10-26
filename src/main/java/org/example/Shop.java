package org.example;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Класс магазинов
 */
public class Shop {

    //Атомик, который ведёт общий подсчёт для всех магазинов
    AtomicLong atomicSum = new AtomicLong(0);

    /**
     * Метод для подсчёта выручки магазина, принимает массив с транзакциями
     * (целые положительные числа)
     * Также добавляет сумму выручки в общую кассу atomicSum
     */
    public void shopCash(int[] mass) {
        int sumShopCash = 0;
        for (int i : mass) {
            sumShopCash = sumShopCash + i;
        }
        atomicSum.addAndGet(sumShopCash);
        Thread thread = Thread.currentThread();
        System.out.println("Выручка для: " +
                thread.getName() + " = " + sumShopCash);
        thread.interrupt();
    }

    /**
     * Метод выводит общую выручку по всем магазинам за день
     */
    public void showAllCash() {
        System.out.println("Общая выручка магазинов: " + atomicSum);
    }
}
