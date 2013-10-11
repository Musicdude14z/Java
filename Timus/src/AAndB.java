import java.util.*;
import java.io.*;

public class AAndB {
  
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    out.println(in.nextInt() + in.nextInt());
    in.close();
    out.flush();
    System.exit(0);
  }

}