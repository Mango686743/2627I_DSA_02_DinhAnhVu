## Bài 3: COS226, Midterm f25, 2a

**Câu hỏi:** Trong các cặp (p, q), những cặp nào có thể là tham số của lệnh `union(p, q)` gần nhất đối với cấu trúc Weighted Quick-Union (link-by-size) có luật tie-break: *cây bằng kích thước thì gốc q trỏ tới gốc p*.

**Đáp án đúng:** `(4, 0)`, `(4, 5)`, `(5, 0)`, `(6, 4)`, `(8, 9)`.

**Giải thích chi tiết (Reverse-Engineering WQU):**

Để một phép toán `union` là thao tác *gần nhất*, cạnh được tạo ra phải nối trực tiếp một nút gốc cũ vào một nút gốc mới (tức là các cạnh liên kết trực tiếp với các root hiện tại `4` và `8`). Các cạnh sâu bên trong như `3 -> 2` hay `7 -> 5` được tạo ra khi `2` và `5` vẫn còn là root, do đó chúng là các thao tác trong quá khứ.

Dựa vào các cạnh nối trực tiếp vào root, ta phân tích:

1. **Kiểm tra cặp `(4, 0)` và `(0, 4)` (Cạnh `0 -> 4`):**
    * Nếu cắt cạnh `0 -> 4`, ta có hai cây: Cây chứa 4 (size = 4) và Cây chứa 0 (size = 4).
    * Kích thước bằng nhau. Áp dụng luật tie-break:
        * `union(4, 0)`: $p=4, q=0$. Gốc của $q$ (là 0) trỏ vào gốc của $p$ (là 4). Tạo thành `0 -> 4` => **Hợp lệ**.
        * `union(0, 4)`: $p=0, q=4$. Gốc của $q$ (là 4) trỏ vào gốc của $p$ (là 0). Tạo thành `4 -> 0` => **Không hợp lệ**.

2. **Kiểm tra cặp `(4, 5)` (Cạnh `5 -> 4`):**
    * Giả sử cạnh cuối cùng được tạo là `5 -> 4`. Cắt cạnh này, ta có Cây chứa 5 (size = 2) và Cây chứa 4 (size = 6).
    * Lệnh `union(4, 5)`: Gốc chứa 5 (size 2) nhỏ hơn nên sẽ trỏ vào gốc chứa 4 (size 6). Tạo thành `5 -> 4` => **Hợp lệ**.

3. **Kiểm tra cặp `(5, 0)`:**
    * Cặp này có thể sinh ra cạnh `0 -> 4` hoặc `5 -> 4` tùy vào thời điểm gọi lệnh. Cả 2 trường hợp đều hợp lệ:
        * *Trường hợp 1 (tạo cạnh `0 -> 4`):* Nếu trước đó Cây 5 (size 4, root=4) và Cây 0 (size 4, root=0). Lệnh `union(5, 0)` sẽ gọi tới `find(5)=4` và `find(0)=0`. Size bằng nhau, gốc của 0 trỏ vào gốc của 5 (là 4), tạo cạnh `0 -> 4`.
        * *Trường hợp 2 (tạo cạnh `5 -> 4`):* Nếu trước đó Cây 5 (size 2, root=5) và Cây 0 (size 6, root=4). Lệnh `union(5, 0)` gọi `find(5)=5` và `find(0)=4`. Size 2 < 6, gốc 5 trỏ vào gốc 4, tạo cạnh `5 -> 4`.
    * => **Hợp lệ**.

4. **Kiểm tra cặp `(6, 4)` (Cạnh `6 -> 4`):**
    * Cắt cạnh `6 -> 4`, ta có Cây chứa 6 (size = 1) và Cây chứa 4 (size = 7).
    * Lệnh `union(6, 4)`: $p=6, q=4$. Cây chứa 6 nhỏ hơn nên trỏ vào cây chứa 4. Tạo cạnh `6 -> 4` => **Hợp lệ**.

5. **Kiểm tra cặp `(8, 9)` (Cạnh `9 -> 8`):**
    * Cắt cạnh `9 -> 8`, ta có Cây chứa 8 (size = 1) và Cây chứa 9 (size = 1).
    * Lệnh `union(8, 9)`: $p=8, q=9$. Bằng kích thước, gốc của $q$ (9) trỏ vào gốc của $p$ (8). Tạo cạnh `9 -> 8` => **Hợp lệ**.