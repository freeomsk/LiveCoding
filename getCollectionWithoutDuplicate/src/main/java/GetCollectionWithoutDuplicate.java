import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class GetCollectionWithoutDuplicate {
    public static void main(String[] args) {
        System.out.println(getCollectionWithoutDuplicate(Arrays.asList(1, 2, 1, 2, 3)));

    }

    private static <T extends Number> Collection<T> getCollectionWithoutDuplicate(Collection<T> collection) {
        return collection.stream().distinct().collect(Collectors.toList());
    }
}