class NegativeBalanceException extends Exception {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) throws NegativeBalanceException {
        if (balance < 0) {
            throw new NegativeBalanceException(
                    "Начальный баланс не может быть отрицательным"
            );
        }

        this.balance = balance;
    }

    public void withdraw(int amount) throws NegativeBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма снятия должна быть положительной"
            );
        }

        if (amount > balance) {
            throw new NegativeBalanceException(
                    "Недостаточно денег. Баланс: " + balance
                            + ", попытка снять: " + amount
            );
        }

        balance -= amount;
        System.out.println("Снято: " + amount);
    }

    public int getBalance() {
        return balance;
    }
}

public class Task3 {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount(1000);

            System.out.println("Начальный баланс: " + account.getBalance());

            account.withdraw(300);
            System.out.println("Остаток: " + account.getBalance());

            account.withdraw(1000);
        } catch (NegativeBalanceException | IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}