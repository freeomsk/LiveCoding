/*
В этом примере мы создаем функцию isSubsequence, которая принимает две строки: searchString и fileName.
Функция проверяет, является ли searchString подпоследовательностью fileName.
Если searchString является подпоследовательностью fileName, функция возвращает true, в противном случае - false.
В функции main мы вызываем функцию isSubsequence с примером названия файла и введенной строки, а затем выводим результат на экран.
 */
public class IsSubsequence {
    public static void main(String[] args) {
//        String fileName = "example_file_name.txt";
//        String searchString = "exm_fn";
        String fileName = "crocodile.txt";
        String searchString = "crdle";

        boolean isSubsequence = isSubsequence(searchString, fileName);
        System.out.println("Введенная строка является подпоследовательностью названия файла: " + isSubsequence);
    }

    public static boolean isSubsequence(String searchString, String fileName) {
        int searchIndex = 0;
        int fileIndex = 0;

        while (searchIndex < searchString.length() && fileIndex < fileName.length()) {
            if (searchString.charAt(searchIndex) == fileName.charAt(fileIndex)) {
                searchIndex++;
            }
            fileIndex++;
        }

        return searchIndex == searchString.length();
    }
}