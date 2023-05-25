import java.util.Stack;

public class FindReplaceableBracket {
    public static void main(String[] args) {
//        String sequence = "(()))(";
        String sequence = "()((";
//        String sequence = "(";
//        String sequence = "()(";


        int index = findReplaceableBracket(sequence);
        System.out.println("Индекс заменяемой скобки: " + index);
        System.out.println(findBracketToReplace(sequence));
        System.out.println(check(sequence));
    }

    // 1 вариант - через стек
//    В этом коде, функция findBracketToReplace проверяет каждый символ в строке.
//    Если символ - открывающая скобка, то он добавляется в стек.
//    Если символ - закрывающая скобка, то проверяется, пуст ли стек.
//    Если стек пуст, то индекс этой скобки сохраняется, поскольку это потенциальная скобка, которую можно заменить на открывающую.
//    Если стек не пуст, то открывающая скобка удаляется из стека.
//    В конце, если стек пуст, и есть сохранённый индекс закрывающей скобки, то возвращается этот индекс.
//    Если в стеке есть одна открывающая скобка, и не сохранён индекс закрывающей скобки, то возвращается индекс открывающей скобки.
//    Во всех остальных случаях возвращается -1, что означает, что невозможно заменить одну скобку так, чтобы получилась правильная скобочная последовательность.
    public static int findReplaceableBracket(String sequence) {
        Stack<Integer> stack = new Stack<>();
        int replaceableIndex = -1;

        for (int i = 0; i < sequence.length(); i++) {
            char bracket = sequence.charAt(i);

            if (bracket == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    replaceableIndex = i;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty() && replaceableIndex == -1) {
            replaceableIndex = stack.pop();
        }

        return replaceableIndex;
    }

    // 2 вариант
    public static int findBracketToReplace(String sequence) {
        int open = 0, close = 0, n = sequence.length();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (sequence.charAt(i) == '(') {
                open++;
            } else if (sequence.charAt(i) == ')') {
                close++;
                if (close > open) {
                    ans = i;
                    break;
                }
            }
        }
        if (open != close) {
            ans = n - 1;
        }
        return ans;
    }


    // Проверка на правильность скобок
    static boolean check(String sequence) {
        int count = 0;
        for (char c : sequence.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

}