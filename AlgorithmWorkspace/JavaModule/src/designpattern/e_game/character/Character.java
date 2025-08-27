package designpattern.e_game.character;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int currentHp;
    protected int atk;
    protected int def;

    public Character(String name, int hp, int atk, int def) {
        super();
        this.name = name;
        this.hp = hp;
        this.currentHp = hp;
        this.atk = atk;
        this.def = def;
    }

    public abstract void attack(Character target);
    public abstract void takeDamage(int damage);

    public void heal(int eat){
        this.currentHp += eat;
        if(this.currentHp > this.hp){
            this.currentHp = this.hp;
        }
        System.out.printf("HP를 %d만큼 회복했습니다. (현재 HP: %d)\n", eat, this.currentHp);
    }

    public String getName() {
        return name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public boolean isDead(){
        return currentHp <= 0;
    }
}

