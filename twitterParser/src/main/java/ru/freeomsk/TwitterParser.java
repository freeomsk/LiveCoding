package ru.freeomsk;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.TreeSet;

public class TwitterParser {

    public Collection<String> twitterParser(Collection<String> messages) {
        return messages.stream()
                .map(message -> message.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(word -> word.startsWith("#"))
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static void main(String[] args) {
        Collection<String> messages = Arrays.asList(
                "Сегодня в #МОСКВА хорошая погода, а в #Питер опять дождь",
                "В #питер сегодня пробки 10 баллов"
        );

        TwitterParser parser = new TwitterParser();
        Collection<String> hashtags = parser.twitterParser(messages);

        System.out.println(hashtags);
    }
}
