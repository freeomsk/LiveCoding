package ru.freeomsk;

public class RemoteController {
    private static int mode = 0; // 0 - режим смены каналов, 1 - режим громкости
    private static int volume = 50; // начальная громкость
    private static int channel = 1; // начальный канал

    public static void main(String[] args) {
        firstButton();
        secondButton();
        thirdButton();
    }

    public static void firstButton() {
        changeMode(); // смена режима при вызове firstButton()
        System.out.println("Режим смены каналов");
    }

    public static void secondButton() {
        if (mode == 0) {
            channel++; // увеличение текущего канала
            System.out.println("Текущий канал: " + channel);
        } else {
            volume++; // увеличение громкости
            System.out.println("Текущая громкость: " + volume);
        }
    }

    public static void thirdButton() {
        if (mode == 0) {
            channel--; // уменьшение текущего канала
            System.out.println("Текущий канал: " + channel);
        } else {
            volume--; // уменьшение громкости
            System.out.println("Текущая громкость: " + volume);
        }
    }

    private static void changeMode() {
        mode = (mode + 1) % 2; // смена режима между 0 и 1
        System.out.println("Смена режима: " + (mode == 0 ? "смена каналов" : "громкость"));
    }

}