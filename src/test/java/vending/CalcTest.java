package vending;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 【演習①-2：写経して、1本動かす】（10分）
 *
 * まずは「自分の打ったテストが緑になる」を体験します。
 * 下の手順どおり、コメントの中のコードを “手で打って” みましょう（コピペ禁止）。
 *
 * ───────────────────────────────────────────────
 *  ① 下の囲みのコードを、この下に打つ：
 *
 *     @Test
 *     void add_2たす3は5になる() {
 *         Calc calc = new Calc();
 *         assertEquals(5, calc.add(2, 3));
 *     }
 *
 *  ② ターミナルで  mvn test  → BUILD SUCCESS を見る
 *  ③ 期待値の 5 をわざと 6 に変えて mvn test → Red の
 *     「expected: <6> but was: <5>」を読む
 *  ④ 5 に戻して、もう一度 Green に
 * ───────────────────────────────────────────────
 *
 *  ※ つまずいたら：赤い波線はだいたい「セミコロン;の付け忘れ」か
 *    「カッコの閉じ忘れ」。エラーはテストの世界の日常です。
 */
class CalcTest {

    // ↓↓↓ ここに手で打つ ↓↓↓
@Test
    void add_2たす3は5になる() {
        Calc calc = new Calc();
        assertEquals(5, calc.add(2, 3));
    }
    // ↑↑↑ ここまで ↑↑↑
}
