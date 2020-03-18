package az.company.booking_project;

public class Validator {
    public static boolean checkPassword(String s){
     return length(s) && CapitalLetters(s)
               && SmallLetters(s) && Symbols(s)
               && Numbers(s);
    }


    public static boolean length(String string){
        return string.length()>=8;
    }

    public static boolean Capital(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public  static boolean Small(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean Number(char c) {
        return c >= '0' && c <= '9';
    }

    public static  boolean Symbol(char c) {

        return c == ')' ||c == '(' || c == '$' || c=='&' || c=='*' ;
    }

    public static boolean SmallLetters(String str){
        for (Character c: str.toCharArray()) {
            if(Small( c)) return  true;
        }
        return  false;
    }

    public static boolean CapitalLetters(String str){
        for (Character c: str.toCharArray()) {
            if(Capital( c)) return  true;
        }
        return  false;
    }

    public static boolean Symbols(String str){
        for (Character c: str.toCharArray()) {
            if(Symbol(c)) return  true;
        }
        return  false;
    }

    public static boolean Numbers(String str){
        for (Character c: str.toCharArray()) {
            if(Number( c)) return  true;
        }
        return  false;
    }
}
