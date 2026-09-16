## Bài 1: COS226, s26, precept1 (Algorithm Analysis)

**Lưu ý lý thuyết quan trọng:** Đề bài yêu cầu sử dụng **cả hai** ký hiệu Tilde ($\sim$) và Big Theta ($\Theta$).
- Ký hiệu $\sim$ (Tilde) **phải giữ lại hằng số dẫn đầu** (leading coefficient) và cơ số của logarit.
- Ký hiệu $\Theta$ (Big Theta) bỏ qua các hằng số và cơ số, chỉ giữ lại bậc tăng trưởng.

Dưới đây là đánh giá tiệm cận chính xác cho từng hàm:

### 1. Hàm số 1
*   **Tilde:** $\sim \frac{1}{2}n$
*   **Big Theta:** $\Theta(n)$
*   *Giải thích:* Vòng lặp chạy từ $10$ đến $n+4$, nhưng mỗi bước nhảy `i += 2`. Do đó số lần lặp bị chia đôi, xấp xỉ $\frac{n}{2}$.

### 2. Hàm số 2
*   **Tilde:** $\sim 3 \log_2 n$
*   **Big Theta:** $\Theta(\log n)$
*   *Giải thích:* Vòng lặp nhân 2 mỗi bước, chạy đến $n^3$. Số lần lặp là $\log_2(n^3)$, theo tính chất logarit rút gọn thành $3 \log_2 n$.

### 3. Hàm số 3
*   **Tilde:** $\sim 100n$
*   **Big Theta:** $\Theta(n)$
*   *Giải thích:* Vòng ngoài chạy $n$ lần, vòng trong chạy đúng định mức $100$ lần. Tổng số lần gọi là đúng $100n$.

### 4. Hàm số 4
*   **Tilde:** $\sim \sqrt{n} \log_3 n$
*   **Big Theta:** $\Theta(\sqrt{n} \log n)$
*   *Giải thích:* Vòng ngoài chạy đến điều kiện $i \times i < n$, tương đương $\sqrt{n}$ lần. Vòng trong nhân 3 mỗi bước, lặp $\log_3 n$ lần.

### 5. Hàm số 5
*   **Tilde:** $\sim n \log_2 n$
*   **Big Theta:** $\Theta(n \log n)$
*   *Giải thích:* Vòng ngoài lặp $n$ lần, vòng trong nhân 2 mỗi bước lặp $\log_2 n$ lần.

### 6. Hàm số 6
*   **Tilde:** $\sim 50 n^3$
*   **Big Theta:** $\Theta(n^3)$
*   *Giải thích:*
    *   Vòng `i` chạy $n$ lần.
    *   Vòng `j` lặp hằng số $100$ lần.
    *   Vòng `k` và `l` tạo thành chuỗi tổng cấp số cộng: $n + (n-1) + \dots + 1 = \frac{n(n+1)}{2} \sim \frac{1}{2}n^2$.
    *   Tổng hợp lại: $n \times 100 \times \frac{1}{2}n^2 = 50n^3$.