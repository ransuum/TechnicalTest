package mathHelper.interfaceOfProgram;

import mathHelper.Logic.Process;
import mathHelper.model.Examples;
import mathHelper.service.ExampleService;

import java.io.*;
import java.util.Scanner;

public class Menu {
    public Scanner scanner = new Scanner(System.in);
    private final ExampleService exampleService = new ExampleService();
    public void menuOfOperation() throws IOException {

        Process process = new Process();
        String l;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("menu.txt")));
        while ((l = bufferedReader.readLine()) != null) {
            System.out.println(l);
        }
        System.out.print("Choose: ");
        int ans = scanner.nextInt();
        switch (ans){
            case 1:

                System.out.println("Examples: 2*x+5=17, -1.3*5/x=1.2, 2*x*x=10, 2*(x+5+х)+5=10, 17=2*x+5");
                String s = scanner.next();
                Examples examples = new Examples();
                examples.setExample(s);
                examples.setEqual(process.procces(s));
                System.out.println(exampleService.save(examples));
                break;
            case 2:
                System.out.print("equals: ");
                double answer = scanner.nextDouble();
                exampleService.getByEquals(answer);
                break;
            case 4:
                System.out.println("Examples: 2*x+5=17, -1.3*5/x=1.2, 2*x*x=10, 2*(x+5+х)+5=10, 17=2*x+5\nid: \nequals: ");
                String s1 = scanner.next();
                Long id = scanner.nextLong();
                double eq = scanner.nextDouble();
                Examples examples1 = new Examples();
                examples1.setId(id);
                examples1.setEqual(eq);
                examples1.setExample(s1);
                exampleService.delete(examples1);
                break;
            default:
                System.out.println("Not supported");
                break;
        }
    }
}
