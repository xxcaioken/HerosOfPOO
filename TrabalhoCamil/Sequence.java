import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Sequence {
    private List<Person> personagens;
    Selection selection = new Selection();

    
    public List<Person> getPersonagens() {
        return personagens;
    }
    
  
    public void setPersonagens(List<Person> personagens) {
        this.personagens = personagens;
    }

    public Person getPersonagem(int PersonNumber) {
        return this.personagens.get(PersonNumber);
    }

    public void exit() {
        exit();
    }

    public void startMenu() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("  SEJA BEM VINDO AO JOGO HERROS OF OOP ");
        System.out.println("     a grande aventura do dragão ");
        System.out.println("           Você deseja: ");
        System.out.println("      Começar a partida(Digite 1) ");
        System.out.println("   Criar seus personagens(Digite 2) ");
        System.out.println("        Sair do jogo(Digite 3) ");
        System.out.println("-------------------------------------------------------------");
        int _selection = selection.selection(3);
        if (_selection == 1) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(" Primeiro voce deve começar criando seus personagens vamos la? Sim(1)Nao(2)");
            System.out.println("-----------------------------------------------------------------------------");
            _selection = selection.selection(2);
            if (_selection == 1)
                initialSelection();
            else {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(" voce deseja sair do jogo? Sim(1)Nao(2)");
                System.out.println("-----------------------------------------------------------------------------");
                _selection = selection.selection(2);
                if (_selection == 1)
                    exit();
                else
                    startMenu();
            }

        }
        if (_selection == 2)
            initialSelection();
        if (_selection == 3)
            this.exit();

    }

    public void initialSelection() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("insira o numero de personagens a serem criados entre 1 a 3");
        int _selectionToNumberOfPerson = selection.selection(3);
        List<Person> personagens = new LinkedList<>();
        for (int i = 0; i < _selectionToNumberOfPerson; i++) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Voce deseja escolher a classe Warrior(1) ou Archer(2) ou Mage(3)");
            int _selection = selection.selection(3);

            if (_selection == 1) {
                personagens.add(new Warrior());
                Warrior guerreiro = (Warrior) personagens.get(i);
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Voce deseja escolher a arma Espada(1) ou Machado(2)");
                _selection = selection.selection(2);
                System.out.println("-----------------------------------------------------------------------------");
                guerreiro.warrior(_selection);
                guerreiro.setName(selection.setPersonName());
            }
            if (_selection == 2) {
                personagens.add(new Archer());
                Archer arqueiro = (Archer) personagens.get(i);
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Voce deseja escolher a arma Arcolongo(1) ou Balestra(2)");
                _selection = selection.selection(2);
                System.out.println("-----------------------------------------------------------------------------");
                arqueiro.archer(_selection);
                arqueiro.setName(selection.setPersonName());
            }
            if (_selection == 3) {
                personagens.add(new Mage());
                Mage mago = (Mage) personagens.get(i);
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Voce deseja escolher a arma Varinha(1) ou Cajado(2)");
                System.out.println("-----------------------------------------------------------------------------");
                _selection = selection.selection(2);
                mago.mage(_selection);
                mago.setName(selection.setPersonName());
            }
        }
        this.setPersonagens(personagens);
    }

    public void battle() {
        Dragon dragon = new Dragon();
        Random random = new Random();
        while (dragon.getLifePoints() > 0) {
            if (personagens.size() == 0) {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("                nos nao conseguimos que pena");
                System.out.println("-----------------------------------------------------------------------------");
            }
            for (int i = 0; i < personagens.size(); i++) {

                Person personagemAtual = getPersonagem(i);
                if (personagemAtual.getLifePoints() > 0) {
                    personagemAtual.setPositionOnBattle(0);
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("voce " + personagemAtual.getName() + " da classe " + personagemAtual.getClasse()
                            + " tem duas opções para a batalha:");
                    System.out.println("                     Atacar(1)");
                    System.out.println("Mudar Posição para defesa e mitigar 10% de dano(2)");
                    System.out.println("            voce ainda tem " + personagemAtual.getLifePoints() + " pontos de vida");
                    System.out.println("            voce tem " + personagemAtual.getDamage() + " de poder de ataque");
                    System.out.println("            voce tem " + personagemAtual.getDefense() + " de poder de defesa");
                    System.out.println("-----------------------------------------------------------------------------");
                    int _selection = selection.selection(2);
                    if (_selection == 1)
                        dragon.setLifePoints(personagemAtual.getDamage());
                    if (_selection == 2)
                        personagemAtual.setPositionOnBattle(1);
                    System.out.println("        o dragao ainda tem " + dragon.getLifePoints() + " de vida");
                    System.out.println("-----------------------------------------------------------------------------");
                
                } else if(personagens.size()>0){
                    personagens.remove(i);
                }
            }
            if(dragon.getLifePoints() > 0 && personagens.size()>0){
                System.out.println("OOOOH nao chegou a vez de o dragão atacar");
                int aleatorio = random.nextInt(personagens.size());
                getPersonagem(aleatorio).setLifePoints(dragon.getDamage());
                System.out.println("O personagem "+getPersonagem(aleatorio).getName()+" foi atacado pelo dragao e lhe restaram "+getPersonagem(aleatorio).getLifePoints()+"Lifepoints");
            }else if(dragon.getLifePoints() < 0){
                System.out.println("Parabens voce conseguiu derrotou o dragao!!");
            }
            

        }

    }
}