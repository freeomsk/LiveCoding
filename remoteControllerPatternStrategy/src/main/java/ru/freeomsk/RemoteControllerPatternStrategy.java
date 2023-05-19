package ru.freeomsk;

public class RemoteControllerPatternStrategy {
    private static final BaseStrategy[] modes = {
            new VolumeStrategy(),
            new ChannelStrategy()};
    private static int currentMode = 0;

    public static void main(String[] args) {
        firstButton();
        secondButton();
        thirdButton();
    }

    public static void firstButton() {
        currentMode = ++currentMode % modes.length;
        System.out.println("Выбран режим: " + modes[currentMode].getModeName());
     }

    public static void secondButton() {
        modes[currentMode].increment();
        System.out.println(modes[currentMode].getValueName() + ": " + modes[currentMode].getValue());
    }

    public static void thirdButton() {
        modes[currentMode].decrement();
        System.out.println(modes[currentMode].getValueName() + ": " + modes[currentMode].getValue());
    }
}


abstract class BaseStrategy {
    private int value = 0;

    public final void increment() {
        value++;
    }
    public final void decrement() {
        value--;
    }
    public final int getValue() {
        return value;
    }
    abstract String getModeName();
    abstract String getValueName();
}

/**
 * Изменение громкости
 */
class VolumeStrategy extends BaseStrategy {

    @Override
    public String getModeName() {
        return "Изменение громкости";
    }

    @Override
    public String getValueName() {
        return "Громкость";
    }
}

/**
 * Переключение каналов
 */
class ChannelStrategy extends BaseStrategy {

    @Override
    public String getModeName() {
        return "Изменение канала";
    }

    @Override
    public String getValueName() {
        return "Канал";
    }
}
