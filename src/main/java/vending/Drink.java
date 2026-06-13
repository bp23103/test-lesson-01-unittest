package vending;

/**
 * 飲み物をあらわすクラス。名前だけを持つ。
 * （このファイルは完成しています。読むだけで OK）
 */
public class Drink {
    private final String name;

    public Drink(String name) {
        this.name = name;
    }

    /** 飲み物の名前を返す（例：「水」「お茶」） */
    public String name() {
        return name;
    }
}
