/* package whatever; // don't place package name! */

import java.util.regex.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String text = "#include<stdio.h>\n#comment\nnot comment yet # now comment" + 
				"\nthis is another not comment //ooh comment lol\n" + 
				"heh/*\n * comment\n * comment\n * comment\n */ lolll\nboop";
		
		System.out.println(text);
		
		Matcher m = Pattern.compile("#(?<firstWord>\\w+)?.*?\n").matcher(text);
        while(m.find()) {
        	String first = m.group("firstWord");
            if(first != null && first.equals("include")) {
                //System.out.prtinln("C");
                //return;
            }
        }
        m.reset();
        text = m.replaceAll("\n");
        
        text = text.replaceAll("//.*?\n", "\n");
        
        text = text.replaceAll("/\\*(.|\n)*?\\*/", "\n");
        
        System.out.println();
        System.out.println();
        
        System.out.println(text);
	}
}