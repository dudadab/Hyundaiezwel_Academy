package designpattern.d_strategy.Item;

public interface DamageWeight {
    int calAttackWeight(int damage);
    int calDefenceWeight(int damage);
}
