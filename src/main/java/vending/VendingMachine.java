package vending;

import java.util.HashMap;
import java.util.Map;

/**
 * 自動販売機。
 * このファイルは「テストされる側（テスト対象）」です。完成しているので、
 * 中身を読んで「どんな部品か」を理解できれば OK。書きかえる必要はありません。
 *
 * 商品と値段：　水 = 150円 ／ お茶 = 120円
 *             コーヒー = 在庫0（＝売切れの例として用意）
 */
public class VendingMachine {

    // 商品名 → 値段
    private final Map<String, Integer> priceTable = new HashMap<>();
    // 商品名 → 在庫数
    private final Map<String, Integer> stockTable = new HashMap<>();

    // いま投入されている金額
    private int inserted = 0;
    // 直前の購入で出たお釣り
    private int change = 0;

    public VendingMachine() {
        priceTable.put("水", 150);
        stockTable.put("水", 5);

        priceTable.put("お茶", 120);
        stockTable.put("お茶", 5);

        // コーヒーは在庫0 → 「売切れ」のテスト用
        priceTable.put("コーヒー", 130);
        stockTable.put("コーヒー", 0);
    }

    /** お金を入れる（何回でも入れられる。合計される） */
    public void insert(int yen) {
        inserted += yen;
    }

    /**
     * いまの投入金額で、その商品が買えるかどうかを返す。
     * （買えるなら true、買えないなら false）
     * 境界値テスト（140円 / 150円）で使う。
     */
    public boolean canBuy(String item) {
        Integer price = priceTable.get(item);
        if (price == null) {
            return false;             // そんな商品はない
        }
        if (stockTable.getOrDefault(item, 0) <= 0) {
            return false;             // 売切れ
        }
        return inserted >= price;     // お金が足りていれば true
    }

    /**
     * 商品を買う。成功すると Drink を返し、お釣りを change にセットする。
     * 買えないときは例外を投げる（＝異常系。コマ2でテストする）。
     */
    public Drink buy(String item) {
        Integer price = priceTable.get(item);
        if (price == null) {
            throw new IllegalArgumentException("その商品はありません: " + item);
        }
        if (stockTable.getOrDefault(item, 0) <= 0) {
            throw new IllegalStateException("売切れです: " + item);
        }
        if (inserted < price) {
            throw new IllegalStateException("金額が足りません: " + item);
        }
        change = inserted - price;        // お釣りを計算
        inserted = 0;                     // 投入金額をリセット
        stockTable.put(item, stockTable.get(item) - 1);  // 在庫を1つ減らす
        return new Drink(item);
    }

    /** 直前の購入で出たお釣りを返す */
    public int change() {
        return change;
    }
}
