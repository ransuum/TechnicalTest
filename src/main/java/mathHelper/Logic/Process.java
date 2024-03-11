package mathHelper.Logic;

import java.util.*;

public class Process {
    public static final Scanner scanner = new Scanner(System.in);
    public List<String> withoutEqual = new ArrayList<>();
    public String firstNumbsBeforeBracket = "";
    public String NumbsAfterBracket = "";
    public List<String> hashMapForNumbPlusMinus = new ArrayList<>();
    List<String> integers = new ArrayList<>();

    public Double procces(String a) {
        List<String> stringList = List.of(a.split(""));
        List<String> e = new ArrayList<>();
        double d = Double.parseDouble(findAfterOrBeforeEquals(stringList).toString());
        List<String> hashMapForNumbDivisionMulti = new ArrayList<>();
        for (int i = 0; i < withoutEqual.size(); i++) {
            String builder = "";
            String numbSign = "";
            if (check() || !check()) {
                e = withoutEqual;
                if (withoutEqual.get(i).equals("+") && !withoutEqual.get(0).equals("+") || withoutEqual.get(i).equals("-")) {
                    int j = i + 1;
                    while (j < withoutEqual.size() && (withoutEqual.get(j).matches("^-?\\d+$") || withoutEqual.get(j).equals("."))) {
                        builder = builder + withoutEqual.get(j);
                        j++;
                        if (j < withoutEqual.size() && withoutEqual.get(j).equals("*")) {
                            numbSign = "/";
                        } else if (j < withoutEqual.size() && withoutEqual.get(j).equals("/")) {
                            numbSign = "*";
                        } else {
                            numbSign = withoutEqual.get(i);
                        }
                    }
                    if (withoutEqual.get(i).equals(numbSign)) {
                        hashMapForNumbPlusMinus.add(numbSign + builder);
                    } else {
                        hashMapForNumbDivisionMulti.add(numbSign + withoutEqual.get(i) + builder);
                    }
                    i = j - 1;
                } else if (withoutEqual.get(i).equals("*") && !withoutEqual.get(0).equals("*") || withoutEqual.get(i).equals("/") && !withoutEqual.get(0).equals("/")
                        || withoutEqual.get(i).equals("-")) {
                    int j = i + 1;
                    while (j < withoutEqual.size() && (withoutEqual.get(j).matches("^-?\\d+$") || withoutEqual.get(j).equals("."))) {
                        builder = builder + withoutEqual.get(j);
                        j++;
                    }
                    if (withoutEqual.get(i).equals("/")) {
                        hashMapForNumbDivisionMulti.add("*" + builder);
                    } else {
                        hashMapForNumbDivisionMulti.add("/" + builder);
                    }
                    i = j - 1;
                } else if (i == 0 && withoutEqual.get(i).matches("^-?\\d+$")) {
                    int j = i;
                    while (j < withoutEqual.size() && (withoutEqual.get(j).matches("^-?\\d+$") || withoutEqual.get(j).equals("."))) {
                        builder = builder + withoutEqual.get(j);
                        j++;
                        if (withoutEqual.get(j).equals("*")) {
                            numbSign = "/";
                        } else if (withoutEqual.get(j).equals("/")) {
                            numbSign = "*";
                        } else {
                            numbSign = "+";
                        }
                    }
                    if (numbSign.equals("+")) {
                        hashMapForNumbPlusMinus.add(numbSign + builder);
                    } else {
                        hashMapForNumbDivisionMulti.add(numbSign + "+" + builder);
                    }
                    i = j - 1;
                }
            }
        }
        findAllX(e);
        int countX = (int) withoutEqual.stream().filter(s1 -> s1.equals("x")).count();
        if (firstNumbsBeforeBracket.isEmpty()) {
            for (int i = 0; i < hashMapForNumbPlusMinus.size(); i++) {
                d = d - Double.parseDouble(hashMapForNumbPlusMinus.get(i));
            }
        } else {
            for (int i = 0; i < hashMapForNumbPlusMinus.size() - 1; i++) {
                d = d - Double.parseDouble(hashMapForNumbPlusMinus.get(i));
            }
        }
        findAllX(withoutEqual);
        for (String s1 : hashMapForNumbDivisionMulti) {
            if (s1.matches("(.*)/(.*)")) {
                String[] array = s1.split("/");
                for (int i = 0; i < array.length; i++) {
                    if (array[i].length() >= 1) {
                        d = d / Double.parseDouble(array[i]);
                    }
                }
            } else if (s1.matches("(.*)*(.*)")) {
                String[] array = s1.split("\\*");
                for (int i = 0; i < array.length; i++) {
                    if (array[i].length() > 1) {
                        d = d * Double.parseDouble(array[i]);
                    }
                }
            }
        }

        if (!firstNumbsBeforeBracket.isEmpty()) {
            d = d / Double.parseDouble(firstNumbsBeforeBracket);
            d = d - Double.parseDouble(hashMapForNumbPlusMinus.get(hashMapForNumbPlusMinus.size() - 1));
        } else {
            System.out.println("Nety skobok");
        }
        long count = hashMapForNumbDivisionMulti.stream().filter(s1 -> s1.equals("-")).count();
        for (int i = 0; i < count; i++) {
            d = d * -1;
        }
        double xSum = 0;
        if (!integers.isEmpty()) {
            for (String s : integers) {
                xSum = xSum + Double.parseDouble(s);
            }
        }
        if (xSum > 0 || xSum < 0) {
            d = d / xSum;
        } else {
            d = Math.pow(d, 1.0 / countX);
        }
        return d;
    }

    public void findAllX(List<String> list) {
        if (check() || !check()) {
            for (int i = 0; i < list.size(); i++) {
                if (i > 0 && i != (list.size() - 1) && list.get(i).equals("x") && (list.get(i - 1).equals("+") || list.get(i - 1).equals("-"))
                        && (list.get(i + 1).equals("+") || list.get(i + 1).equals("-")) && !list.get(i - 1).equals("*") && !list.get(i - 1).equals("/")
                && !list.get(i + 1).equals("*")&& !list.get(i + 1).equals("/") && !list.get(i - 2).equals("*")) {
                    integers.add(list.get(i - 1) + 1);
                }
                if (list.get(i).equals("x") && i == 0 && !list.get(i + 1).equals("*")&& !list.get(i + 1).equals("/")) {
                    integers.add("+" + 1);
                }
                if (list.get(i).equals("x") && i == (list.size() - 1) && (list.get(i - 1).equals("+") || list.get(i - 1).equals("-"))
                        && !list.get(i - 1).equals("*")&& !list.get(i - 1).equals("/") && !list.get(i - 2).equals("*")) {
                    integers.add(list.get(i - 1) + 1);
                }
            }
        }
    }

    public boolean check() {
        boolean ok = false;
        for (int i = 0; i < withoutEqual.size(); i++) {
            String NumbsAfterBracket = "";
            if (withoutEqual.get(i).equals("(")) {
                int j = 0;
                while (j < i && (withoutEqual.get(j).matches("^-?\\d+$") || withoutEqual.get(j).equals(".") || withoutEqual.get(j).equals("-")
                        || !withoutEqual.get(j).equals("("))) {
                    if (withoutEqual.get(j).equals("*")) {
                        withoutEqual.remove(j);
                        break;
                    } else {
                        firstNumbsBeforeBracket = firstNumbsBeforeBracket + withoutEqual.get(j);
                        withoutEqual.remove(j);
                    }
                }
                i = 0;
                withoutEqual.remove("(");
                ok = true;
            } else if (withoutEqual.get(i).equals(")")) {
                int j = i + 1;
                while (j < withoutEqual.size() && (withoutEqual.get(j).matches("^-?\\d+$") || withoutEqual.get(j).equals(".")
                        || withoutEqual.get(j).equals("-")
                        || withoutEqual.get(j).equals("+"))) {
                    NumbsAfterBracket = NumbsAfterBracket + withoutEqual.get(j);
                    withoutEqual.remove(j);
                }
                hashMapForNumbPlusMinus.add(NumbsAfterBracket);
                withoutEqual.remove(i);
                ok = true;
                i = j - 1;
            } else {
                ok = false;
            }
        }
        return ok;

    }

    public StringBuilder findAfterOrBeforeEquals(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        int whereIsEqual = 0;
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals("=") && stringList.stream().filter(str -> str.equals("=")).count() == 1) {
                whereIsEqual = i;
                if (i > (stringList.size() - 1 - i)) {
                    for (int j = 0; j < whereIsEqual; j++) {
                        withoutEqual.add(stringList.get(j));
                    }
                    for (int j = i + 1; j < stringList.size(); j++) {
                        stringBuilder.append(stringList.get(j));
                    }
                } else {
                    for (int j = whereIsEqual + 1; j < stringList.size(); j++) {
                        withoutEqual.add(stringList.get(j));
                    }
                    for (int j = 0; j < i; j++) {
                        stringBuilder.append(stringList.get(j));
                    }
                }
            }
        }
        return stringBuilder;
    }
}
