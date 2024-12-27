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

    private int handleIf(int currentLine) {
        String ifLine = code.get(currentLine);
        //   System.out.println(ifLine);
        //    System.out.println(ifLine);
        //     System.out.println(ifLine);
        String condition = ifLine.substring(ifLine.indexOf("if") + 2, ifLine.indexOf("{")).trim();
        //      System.out.println(condition);
        int startLine = currentLine + 1;
        int endLine = findMatchingBrace(startLine);
        //        System.out.println(code.get(endLine-2));
        //        System.out.println(startLine +" and we end at" + endLine);
        //    System.out.println(ifLine);
        //  System.out.println(evaluateCondition(condition));
        boolean is_break=false;
        if (evaluateCondition(condition)) {
            for (int i = startLine; i < endLine; i++) {
                //    System.out.println(code.get(i).trim());
                //  System.out.println(code.get(i).trim());
                if (code.get(i).trim().equals("break")) {   is_break=true; break;   }
                handleStatement(code.get(i).trim());
            }
        }
        if (is_break)  { return -1; }
        return endLine + 1;
    }

    private void handleFor() {
        String forLine = code.get(currentLine);
        String[] parts = forLine.substring(forLine.indexOf("for") + 3, forLine.indexOf("{")).trim().split(";");
        // Initialize
        String initPart = parts[0].trim();
        String[] initParts = initPart.split(":=");
        String iterVar = initParts[0].trim();
        variables.put(iterVar, evaluateExpression(initParts[1].trim()));
        // Condition and increment
        String condition = parts[1].trim();
        int startLine = currentLine + 1;
        int endLine = findMatchingBrace(startLine);
        //  System.out.println(code.get(endLine-3));
        while (evaluateCondition(condition)) {
            boolean is_break=false;
            //    System.out.println(variables.get("isPrime"));
            for (int i = startLine; i < endLine; i++) {
                if (code.get(i)=="") { continue; }
                //  System.out.println(code.get(i));
                if (code.get(i).trim().equals("break")) { is_break=true; break ;}
                //     System.out.println(code.get(i));
                if (code.get(i).trim().startsWith("if")) {
                    //  System.out.println(code.get(i));
                    //                    int helper = handleIf(i);
                    // System.out.println(helper);
                    if (helper==-1) { is_break=true; break;  }
                    i=helper-1;
                    continue;
                }
                //      System.out.println(code.get(i));
                handleStatement(code.get(i).trim());
            }
            if (is_break) { break; }
            // Handle increment
            variables.put(iterVar, variables.get(iterVar) + 1);
        }
        currentLine = endLine + 1;
    }

    private int findMatchingBrace(int start) {
        int count = 1;
        for (int i = start; i < code.size(); i++) {
            if (code.get(i).contains("{")) count++;
            if (code.get(i).contains("}")) count--;
            if (count == 0) return i;
        }
        return code.size();
    }

    public static void main(String[] args) {

    }
}
