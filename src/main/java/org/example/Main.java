package org.example;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Main Class!
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        // Созданём 3 потока магазинов с разной выручкой
        Thread shop1 = new Thread(() -> shop.shopCash(new int[]{300, 500, 600, 1000}), "Магазин 1");
        Thread shop2 = new Thread(() -> shop.shopCash(new int[]{400, 100}), "Магазин 2");
        Thread shop3 = new Thread(() -> shop.shopCash(new int[]{200, 100, 500, 600, 2000, 4000}), "Магазин 3");
        shop1.start();
        shop2.start();
        shop3.start();
        while (true) {
            //Как только все 3 магазина завершают подсчёт - выводим общую сумму по всем магазинам.
            if (shop1.isInterrupted() && shop2.isInterrupted() && shop3.isInterrupted()) {
                shop.showAllCash();
                break;
            }
        }
    }
}
