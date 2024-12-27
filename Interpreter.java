import java.util.*;
public class Interpreter {

    private final Map<String, Integer> variables = new HashMap<>();
    private int currentLine = 0;
    private final List<String> code = new ArrayList<>();

    public void eval(String program) {
        code.clear();
        code.addAll(Arrays.asList(program.split("\n")));
        currentLine = 0;
        while (currentLine < code.size()) {
            String line = code.get(currentLine).trim();
            if (line.isEmpty()) {
                currentLine++;
                continue;
            }
            if (line.startsWith("for")) {
                handleFor();
                continue;
            }
            if (line.startsWith("if")) {
                int q=handleIf(currentLine);
                currentLine=q;
                continue;
            }
            handleStatement(line);
            currentLine++;
        }
    }

    private void handleStatement(String line) {
        if (line.contains(":=")) {
            handleDeclaration(line);
        } else if (line.contains("+=")) {
            handleIncrement(line);
        } else if (line.contains("*=")) {
            handleMultiplication(line);
        } else if (line.startsWith("Println")) {
            handlePrint(line);
        } else if (line.contains("=") && !(line.contains("==")))
        {
            handleassignment(line);
        }
    }

    private void handleassignment(String line) {
        String[] parts = line.split("=");
        String varName = parts[0].trim();
        //    System.out.println(Arrays.toString(parts));
        int ass = evaluateExpression(parts[1].trim());
        //  System.out.println(variables.get("isPrime"));
        variables.put(varName, ass);
    }

    private void handleDeclaration(String line) {
        String[] parts = line.split(":=");
        String varName = parts[0].trim();
        String expression = parts[1].trim();
        variables.put(varName, evaluateExpression(expression));
    }

    private void handleIncrement(String line) {
        String[] parts = line.split("\\+=");
        String varName = parts[0].trim();
        int currentValue = variables.getOrDefault(varName, 0);
        int increment = evaluateExpression(parts[1].trim());
        variables.put(varName, currentValue + increment);
    }

    private void handleMultiplication(String line) {
        String[] parts = line.split("\\*=");
        String varName = parts[0].trim();
        int currentValue = variables.getOrDefault(varName, 1);
        int multiplier = evaluateExpression(parts[1].trim());
        variables.put(varName, currentValue * multiplier);
    }

    private void handlePrint(String line) {
        String varName = line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim();
        System.out.println(evaluateExpression(varName));
    }



    public static void main(String[] args) {

    }
}
