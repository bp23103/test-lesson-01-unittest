package vending;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 【教員用・解答】VendingMachineTest の穴埋め完成版。
 *  ※ 配布時はこのファイル（解答フォルダ）を学生に渡さないこと。
 *
 *  異常系（ケース3・4）も参考として assertThrows で書いてあります。
 *  これはコマ2で扱う内容です。
 */
class VendingMachineTest {

    // ───────── 正常系 ─────────

    @Test
    void ちょうどの金額で買える() {            // ケース1
        VendingMachine vm = new VendingMachine();
        vm.insert(150);
        Drink d = vm.buy("水");
        assertEquals("水", d.name());
        assertEquals(0, vm.change());
    }

    @Test
    void お釣りが正しく出る() {                 // ケース2（穴埋めの答え）
        VendingMachine vm = new VendingMachine();
        vm.insert(200);                        // ← 200円入れる
        Drink d = vm.buy("水");
        assertEquals("水", d.name());
        assertEquals(50, vm.change());         // ← お釣りは50円
    }

    // ───────── 境界値 ─────────

    @Test
    void 境界のすぐ下では買えない() {            // ケース5（穴埋めの答え）
        VendingMachine vm = new VendingMachine();
        vm.insert(140);
        assertEquals(false, vm.canBuy("水"));  // ← false
    }

    @Test
    void 境界の上側なら買える() {                // ケース6（穴埋めの答え）
        VendingMachine vm = new VendingMachine();
        vm.insert(150);
        assertEquals(true, vm.canBuy("水"));   // ← true
    }

    // ───────── 異常系（参考・コマ2の内容）─────────

    @Test
    void 金額不足では買えない() {                // ケース3
        VendingMachine vm = new VendingMachine();
        vm.insert(100);
        // 100円で150円の水は買えない → 例外が出るはず
        assertThrows(IllegalStateException.class, () -> vm.buy("水"));
    }

    @Test
    void 売切れの商品は買えない() {              // ケース4
        VendingMachine vm = new VendingMachine();
        vm.insert(200);
        // コーヒーは在庫0 → 例外が出るはず
        assertThrows(IllegalStateException.class, () -> vm.buy("コーヒー"));
    }
}
