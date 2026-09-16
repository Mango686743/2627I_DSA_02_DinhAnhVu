## Bài 3: COS226, Midterm f25, 1d (Algorithm Analysis)

**Câu hỏi:** Biểu thức nào mô tả đúng về hàm $f(n) = 2n^2 + 2n + 6\log_2 n$?

**Các đáp án đúng (Select all that apply):**
- $O(n^2)$, $O(n^3)$
- $\Omega(n^2)$, $\Omega(n)$, $\Omega(\log n)$

**Giải thích chi tiết:**

Hàm số $f(n) = 2n^2 + 2n + 6\log_2 n$. Khi $n$ tiến tới vô cùng, số hạng chi phối (dominant term) quyết định tốc độ tăng trưởng của hàm là $2n^2$. Do đó, bậc tăng trưởng thực sự của hàm này là $\Theta(n^2)$.

**1. Về Big O (Cận trên - Upper Bound):**
*   Big O mô tả một hàm số tăng trưởng **nhanh hơn hoặc bằng** $f(n)$.
*   Vì $f(n)$ tăng trưởng theo bậc 2, nên cận trên chặt chẽ của nó là $O(n^2)$.
*   Bất kỳ hàm nào có bậc lớn hơn $n^2$ (như $n^3, n^4$) cũng tự động là cận trên hợp lệ của $f(n)$.
*   => Chọn **$O(n^2)$** và **$O(n^3)$**.

**2. Về Big Omega ($\Omega$ - Cận dưới - Lower Bound):**
*   Big Omega mô tả một hàm số tăng trưởng **chậm hơn hoặc bằng** $f(n)$. Nói cách khác, $f(n)$ phải tăng nhanh ít nhất bằng hàm đó.
*   Vì $f(n)$ tăng trưởng theo bậc 2, cận dưới chặt chẽ của nó là $\Omega(n^2)$.
*   Nếu $f(n)$ đã tăng nhanh bằng bậc 2, thì hiển nhiên nó tăng nhanh hơn các hàm có bậc thấp hơn như tuyến tính ($n$) hay logarit ($\log n$). Do đó, các cận dưới lỏng lẻo hơn vẫn hoàn toàn chính xác.
*   => Chọn **$\Omega(n^2)$**, **$\Omega(n)$** và **$\Omega(\log n)$**.
*   *(Lưu ý: $\Omega(n^3)$ sai vì $n^2$ không thể tăng nhanh bằng $n^3$).*