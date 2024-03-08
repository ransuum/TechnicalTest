package mathHelper;

import mathHelper.Logic.Process;
import mathHelper.interfaceOfProgram.Menu;
import mathHelper.model.Examples;
import mathHelper.service.ExampleService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.menuOfOperation();
    }
}
