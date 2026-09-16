## Bài 2: COS226, Midterm f25, 1c (Algorithm Analysis)

**Câu hỏi:** Hàm `op()` được gọi bao nhiêu lần (tính theo $n$)?

**Đáp án đúng:** Chọn phương án `~ n^4 log_2 n` (Lựa chọn thứ 4)

**Giải thích chi tiết:**
Đoạn code gồm 3 vòng lặp lồng nhau. Ta phân tích từng phần:

1. **Hai vòng lặp ngoài cùng (`i` và `j`):**
   ```java
   for (int i = 0; i < n*n; i++)
       for (int j = i+1; j < n*n; j++)
   ```
    - Vòng lặp `i` chạy từ $0$ đến $n^2 - 1$.
    - Vòng lặp `j` phụ thuộc vào `i`, chạy từ $i+1$ đến $n^2 - 1$.
    - Tổng số lần lặp của 2 vòng này tạo thành cấp số cộng:
      $(n^2-1) + (n^2-2) + \dots + 1 = \frac{n^2(n^2-1)}{2} \sim \frac{1}{2}n^4$.

2. **Vòng lặp trong cùng (`k`):**
   ```java
   for (int k = 1; k <= n*n; k = k*2)
   ```
    - Vòng lặp này hoàn toàn độc lập với `i` và `j`.
    - `k` nhân 2 sau mỗi bước, chạy tới điều kiện $n^2$.
    - Số lần lặp là $\log_2(n^2)$. Áp dụng tính chất của logarit: $\log_2(n^2) = 2 \log_2 n$.
    - Do đó, vòng lặp trong cùng có đánh giá tiệm cận là $\sim 2 \log_2 n$.

3. **Tổng hợp số lần gọi hàm `op()`:**
   Nhân số lần lặp của các vòng phụ thuộc lại với nhau:
   Tổng số phép toán $\sim \left(\frac{1}{2}n^4\right) \times (2 \log_2 n) = n^4 \log_2 n$.

Phép triệt tiêu hằng số $\frac{1}{2}$ và $2$ diễn ra, cho ra đáp án cuối cùng là $\sim n^4 \log_2 n$.