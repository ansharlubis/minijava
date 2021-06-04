import syntaxtree.*;
import visitor.*;
import parser.*;
import symbol.Table;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
  public static void main(String [] args) throws IOException {
    try {
      File initialFile = new File("C:/Users/Luthfan Anshar Lubis/Documents/study/introduction-compiler/minijava/src/main/resources/SampleA3");
      InputStream stream = new FileInputStream(initialFile);
      Program root = new MiniJavaParser(stream).Program();

      SymbolTreeVisitor symbolTreeVisitor = new SymbolTreeVisitor();
      root.accept(symbolTreeVisitor);
      Table symbolTable = symbolTreeVisitor.symbolTable;

      TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(symbolTable);
      root.accept(typeCheckerVisitor);
    }
    catch (ParseException e) {
      System.out.println(e.toString());
    }
  }
}
