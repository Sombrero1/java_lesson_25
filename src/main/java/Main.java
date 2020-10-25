import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    public static void main(String[] args) {
        regular("0.0.0.0");
        regular("192.167.213.123");
        regular("192.168.100.123");
        regular("013.144.124.124");
        regular("-1.3.2.3");
        regular("256.100.100.100");
        regular("prikol");
        regular("0262.204.124.124");

        regularSkobki("(3*+*5)*–*9*×*4.");
        regularSkobki("((3*+*5)*–*9*×*4.");
        regularSkobki("((3*+*5)*–*9*×*4.");
        regularSkobki("(3*+*5)*–*9)*×*4.");
        regularSkobki("(3*+*5)*–*9()*×*4.");
        regularSkobki("(3*+*5)*–*(9()*×*4.");
        regularSkobki("(3*+*5)*–*(9()*×*4.)");




    }
    public static void regular(String c){
        //String regex="^(25[0-5]|2[0-4][0-9]|[01][0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        String regex="^(((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]|0)\\.){3}(25[0-5]|2[0-4][0-9]|[1]?[1-9][1-9]|0))";
        Pattern rg=Pattern.compile(regex);


        Matcher mg=rg.matcher(c);
        if(mg.find()) {
            System.out.println(c.substring(mg.start(), mg.end()));
        }
        else{
            System.out.println("Дай айпишник, а не " + c);
        }

    }
    public static void regularSkobki(String c){ // Вначале убираем все лишние символы, после если находим пару скобок, то заменяем. Если не найдено и не "", то баним
        String temp=c;
        Pattern rg=Pattern.compile("\\([^\\(\\)]*\\)");
        Pattern rgMini=Pattern.compile("[^\\(\\)]");
        temp=rgMini.matcher(temp).replaceAll("");//убираем все другие символы

        Matcher mg=rg.matcher(temp);//для скобок
        while (true) {
            if (mg.find()) {
                temp=mg.replaceAll("");

            }
            else{

                if(temp.length()==0) System.out.println("Верно: " + c);
                else{
                    System.out.println("Неверно: "+c);

                }
                return;
            }
        }
    }



}
