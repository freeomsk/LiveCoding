import java.util.Stack;

public class FindReplaceableBracket {
    public static void main(String[] args) {
//        String sequence = "(()))(";
        String sequence = "(())((";
//        String sequence = "()((";
//        String sequence = "(";
//        String sequence = "()(";

//        int index = findReplaceableBracket(sequence);
//        System.out.println("Индекс заменяемой скобки: " + index);
        System.out.println(findReplaceableBracket(sequence));
    }

//    В этом коде, функция findBracketToReplace проверяет каждый символ в строке.
//    Если символ - открывающая скобка, то он добавляется в стек.
//    Если символ - закрывающая скобка, то проверяется, пуст ли стек.
//    Если стек пуст, то индекс этой скобки сохраняется, поскольку это потенциальная скобка, которую можно заменить на открывающую.
//    Если стек не пуст, то открывающая скобка удаляется из стека.
//    В конце, если стек пуст, и есть сохранённый индекс закрывающей скобки, то возвращается этот индекс.
//    Если в стеке есть одна открывающая скобка, и не сохранён индекс закрывающей скобки, то возвращается индекс открывающей скобки.
//    Во всех остальных случаях возвращается -1, что означает, что невозможно заменить одну скобку так, чтобы получилась правильная скобочная последовательность.

    public static int findReplaceableBracket(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        boolean hasOpen = false;
        int wrong = -1;

        if (len % 2 != 0) return wrong; // odd

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                hasOpen = true;
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) { // first missed (
                    wrong = wrong < 0 ? i : wrong;
                } else {
                    stack.pop();
                }
            }
        }

        // wrong = replace to ( or -1
        if (!stack.isEmpty()) {
            if (wrong >= 0 || stack.size() > 2) {
                wrong = -1; // many
            } else {
                wrong = stack.pop(); // replace to )
            }
        } else {
            if (!hasOpen && len > 2) wrong = -1; // has ) only
        }
        return wrong;
    }

}