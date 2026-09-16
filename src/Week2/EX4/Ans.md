## Bài 4: COS226, Midterm s25, 1 (Memory Analysis)

**Câu hỏi:** Một đối tượng BST sử dụng bao nhiêu bộ nhớ (tính bằng byte) theo kích thước n (số cặp key-value)? Biểu diễn bằng ký hiệu xấp xỉ (~).

**Đáp án đúng:** `~ 72n`

**Giải thích chi tiết (Dựa trên mô hình bộ nhớ 64-bit):**

Để tính toán, ta cần tính kích thước của một đối tượng `Node`, sau đó nhân với $n$ và bỏ qua các hằng số không đáng kể theo quy tắc của ký hiệu $\sim$.

**1. Tính kích thước của 1 đối tượng `Node`:**
*   **Object overhead:** `16 bytes` (Mặc định cho mọi object).
*   **Hidden reference:** `8 bytes` (Do `Node` là *non-static inner class*, nó chứa một con trỏ ngầm định trỏ ra lớp cha `BST`).
*   **5 biến tham chiếu** (`key`, `value`, `parent`, `left`, `right`): $5 \times 8 = 40$ bytes. *(Lưu ý: Chỉ tính kích thước của tham chiếu, không tính kích thước của object mà nó trỏ tới).*
*   **1 biến nguyên thủy** (`count` kiểu `int`): `4 bytes`.
*   *Tổng kích thước thô:* $16 + 8 + 40 + 4 = 68$ bytes.
*   *Padding (Căn chỉnh bộ nhớ):* 68 không chia hết cho 8. Cần thêm 4 bytes padding để đạt bội số gần nhất của 8 là 72.
    $\rightarrow$ Vậy mỗi đối tượng `Node` chiếm **72 bytes**. $n$ đối tượng sẽ chiếm $72n$ bytes.

**2. Tính kích thước của đối tượng vỏ `BST`:**
*   **Object overhead:** `16 bytes`.
*   **Tham chiếu `root`:** `8 bytes`.
*   **Biến `int n`:** `4 bytes`.
*   *Tổng kích thước thô:* $16 + 8 + 4 = 28$ bytes.
*   *Padding:* Thêm 4 bytes để đạt bội số của 8 là 32 bytes.
    $\rightarrow$ Vỏ `BST` chiếm **32 bytes**.

**3. Kết luận tiệm cận:**
Tổng bộ nhớ chính xác là: $32 + 72n$ (bytes).
Khi biểu diễn bằng ký hiệu xấp xỉ ($\sim$) cho $n$ rất lớn, ta bỏ qua phần hằng số 32 của vỏ cây.
Kết quả cuối cùng là **$\sim 72n$**.