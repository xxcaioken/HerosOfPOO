import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Sequence {
    private List<Person> personagens;

    public List<Person> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Person> personagens) {
        this.personagens = personagens;
    }





    public void initialSelection(){
        System.out.println("insira o numero de personagens desejados ");
        Scanner scanner = new Scanner(System.in);
        int j = scanner.nextInt();
        List<Person> personagens = new LinkedList<>();
        for(int i = 0; i < j;i++){
            System.out.println("Voce deseja escoler a classe Warrior(0) ou Archer(1) ou Mage(2)");
            int h=scanner.nextInt();
                if(h==0){
                    personagens.add(new Warrior());
                                }
                if(h==1){
                    personagens.add(new Archer());
                }
                if(h==2){
                    personagens.add(new Mage());
                }
            }
            this.setPersonagens(personagens);

        }
    
    
}
