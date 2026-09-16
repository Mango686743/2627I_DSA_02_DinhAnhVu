## Bài 5: COS226, Midterm f24, 2a
**Câu hỏi:** Đoạn code in từ "hello" bao nhiêu lần?

**Đáp án đúng:** `~ 50n^2`

**Giải thích chi tiết:**
Ta chia đoạn code thành 2 cụm để phân tích:
1.  **Vòng lặp trong cùng (biến `k`):**
    ```java
    for (int k = 1; k <= n; k = k + n/100)
    ```
    Biến `k` bắt đầu từ 1 và nhảy từng bước có độ dài $\frac{n}{100}$. Số lần lặp xấp xỉ bằng tổng quãng đường chia cho bước nhảy: $n \div \left(\frac{n}{100}\right) = 100$. Vòng lặp này luôn chạy một hằng số là 100 lần.

2.  **Hai vòng lặp ngoài cùng (biến `i` và `j`):**
    ```java
    for (int i = 1; i <= n; i++)
        for (int j = n; j >= i; j--)
    ```
    Khi `i = 1`, vòng `j` lặp $n$ lần. Khi `i = 2`, vòng `j` lặp $n-1$ lần... Khi `i = n`, vòng `j` lặp 1 lần.
    Tổng số lần lặp là một cấp số cộng: $n + (n-1) + \dots + 1 = \frac{n(n+1)}{2} \sim \frac{1}{2}n^2$.

3.  **Tổng hợp:**
    Nhân số lần lặp lại: $\left(\frac{1}{2}n^2\right) \times 100 = 50n^2$. Đáp án tiệm cận là $\sim 50n^2$.
