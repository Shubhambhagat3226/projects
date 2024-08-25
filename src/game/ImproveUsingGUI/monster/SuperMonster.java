package game.ImproveUsingGUI.monster;

public class SuperMonster {

    String name;
    int hp;
    int attack;
    String attackMessage;

    public void setHp(int hp) {
        this.hp = this.hp + hp;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public String getAttackMessage() {
        return attackMessage;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return (name + ": " + hp);
    }
}
