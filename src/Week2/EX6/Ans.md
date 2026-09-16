## Bài 6: COS226, Midterm f24, 2b
**Câu hỏi:** Chọn biểu thức mô tả đúng về hàm $n\log^2 n + 3n\sqrt{n} - 5n$.

**Các đáp án đúng:**
- $O(n^3)$
- $O(n\sqrt{n})$
- $\Omega(\log n)$

**Giải thích chi tiết:**
*   Hàm số đã cho có các thành phần: $n(\log n)^2$, $3n^{1.5}$ và $-5n$. Khi $n$ tiến tới vô cực, hàm đa thức $n^{1.5}$ luôn tăng trưởng nhanh hơn bất kỳ hàm logarit nào. Do đó, số hạng chi phối (dominant term) là $3n\sqrt{n}$. Bậc tăng trưởng của hàm là $\Theta(n\sqrt{n})$.
*   **Tại sao $\sim n\sqrt{n}$ sai?** Ký hiệu Tilde ($\sim$) yêu cầu phải giữ lại hệ số dẫn đầu. Biểu thức đúng phải là $\sim 3n\sqrt{n}$. Việc bỏ hệ số 3 khiến đáp án đầu tiên bị sai.
*   **Tại sao chọn $O(n\sqrt{n})$ và $O(n^3)$?** Ký hiệu Big O là cận trên. Hàm số bị chặn sát nhất bởi $O(n\sqrt{n})$. Vì $n^3$ lớn hơn $n\sqrt{n}$, nên $O(n^3)$ cũng là một cận trên hoàn toàn hợp lệ.
*   **Tại sao chọn $\Omega(\log n)$?** Ký hiệu Big Omega là cận dưới. Hàm $n^{1.5}$ tăng trưởng nhanh hơn hàm $\log n$ rất nhiều, nên $\log n$ chắc chắn là một cận dưới hợp lệ.