package vending;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 【演習①-3：穴埋めで、仕様書をコードにする】（20分）
 *
 *  自分が設計したテストケース仕様書（自販機）の値を、
 *  下のコードの  _____  に入れていきます。
 *
 *  進め方：
 *   ① まず mvn test → ケース1（完成例）だけ Green になることを確認
 *   ② ケース2（正常系）の _____ に、仕様書 No.2 の値を入れる
 *   ③ ケース5・6（境界値）の _____ に、買えるか（true / false）を入れる
 *   ④ 全部 Green に。Red が出たら expected / but was を読む
 *
 *  ★ 異常系（仕様書 No.3・4）は、設計までで OK。
 *    コードにするには assertThrows という新しい道具が要るので、コマ2で扱います。
 *
 *  ヒント：assertEquals(期待値, 実際の値)  ← 左が「こうなるはず」、右が「実際」
 */
class VendingMachineTest {

    // ───────── 正常系 ─────────

    @Test
    void ちょうどの金額で買える() {            // ケース1：完成例（写経の確認用）
        VendingMachine vm = new VendingMachine();
        vm.insert(150);                        // 150円入れる
        Drink d = vm.buy("水");                // 水を買う
        assertEquals("水", d.name());          // 水が出たか
        assertEquals(0, vm.change());          // お釣りは0円か
    }

    @Test
    void お釣りが正しく出る() {                 // ケース2：穴埋め
        VendingMachine vm = new VendingMachine();
        vm.insert(_____);                      // ★仕様書No.2「いくら入れる？」
        Drink d = vm.buy("水");
        assertEquals("水", d.name());
        assertEquals(_____, vm.change());      // ★仕様書No.2「お釣りはいくら？」
    }

    // ───────── 境界値 ─────────

    @Test
    void 境界のすぐ下では買えない() {            // ケース5：穴埋め
        VendingMachine vm = new VendingMachine();
        vm.insert(140);                        // 水(150円)に1円足りない
        assertEquals(_____, vm.canBuy("水"));  // ★買える？ true / false で
    }

    @Test
    void 境界の上側なら買える() {                // ケース6：穴埋め
        VendingMachine vm = new VendingMachine();
        vm.insert(150);                        // ちょうど150円
        assertEquals(_____, vm.canBuy("水"));  // ★買える？ true / false で
    }

    // ───────── 異常系（仕様書 No.3・4）─────────
    //
    //  ここはコマ2で書きます。今日は「設計まで」できていれば OK。
    //
    //  ・金額不足（100円で水を買おうとする）→ エラーになるはず
    //  ・売切れ（コーヒーを買おうとする）   → エラーになるはず
    //
    //  これらは「正しく失敗するか」を確かめるテストで、
    //  assertThrows というしくみを使います。お楽しみに。
}
