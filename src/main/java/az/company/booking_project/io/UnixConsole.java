package az.company.booking_project.io;

import java.util.Scanner;

public class UnixConsole implements Console {

  private final Scanner sc;

  public UnixConsole(Scanner sc) {
    this.sc = sc;
  }



  @Override
  public String readLn() {
    return sc.nextLine();
  }

  @Override
  public void print(String line) {
    System.out.print(line);
  }

  @Override
  public void close() {
    sc.close();
  }
}
