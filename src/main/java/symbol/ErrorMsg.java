package symbol;

public class ErrorMsg {
  private boolean anyErrors;
  public void complain(String msg) {
    anyErrors = true;
    System.err.println(msg);
  }
}
