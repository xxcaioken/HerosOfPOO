import java.util.Scanner;

public class Selection {
    private int BIGGEROPTION;
    Scanner scanner = new Scanner(System.in);
    
    public int getBIGGEROPTION() {
        return BIGGEROPTION;
    }

    public void setBIGGEROPTION(int bIGGEROPTION) {
        BIGGEROPTION = bIGGEROPTION;
    }


    public String setPersonName(){
        System.out.println("insira o nome do personagem");
        String name = scanner.next();
        return name;
    }

    public int selection(int _BIGGEROPTION){
        this.setBIGGEROPTION(_BIGGEROPTION);
        int entry=scanner.nextInt();
        while(entry<0 || entry>this.BIGGEROPTION){
            System.out.println("insira um valor valido");
            entry=scanner.nextInt();
        }
        return entry;
    }
    
}
