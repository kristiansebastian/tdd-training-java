public class Wallet {

    private float money = 0.0f;

    public float getMoney() {
        return money;
    }

    public void addMoney(float money) {
        this.money += money;
    }

    public void reset(float money) {
        this.money = money;
    }
}
