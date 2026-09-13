## Bài 4: COS226, Midterm s25, 2a (Weighted Quick-Union)

**Câu hỏi:** Dựa vào biểu diễn `parent-link` của mảng, `parent[8]` có thể nhận những giá trị nào trong các giá trị từ 0 đến 9?

**Đáp án đúng:** `0`, `4`, `8`.

**Giải thích chi tiết:**
Từ mảng `parent[]` ban đầu, ta phục dựng được 3 thành phần liên thông (3 cây) như sau:
1. **Cây thứ nhất:** Có gốc là `0` (vì `parent[0] = 0`). Cây này chứa các đỉnh {0, 1, 2, 3}, tổng kích thước (size) là 4.
2. **Cây thứ hai:** Có gốc là `4` (vì `parent[4] = 4`). Cây này chứa các đỉnh {4, 5, 6, 7}, tổng kích thước (size) là 4.
3. **Cây thứ ba:** Chứa đỉnh `8` và `9`. Do `parent[9] = 8`, đỉnh 8 đóng vai trò là cha của 9. Kích thước của cây này là 2.

Theo đặc tả của thuật toán Weighted Quick-Union (link-by-size), lệnh `union` luôn lấy gốc của cây nhỏ hơn trỏ trực tiếp vào gốc của cây lớn hơn. Ta xét các trường hợp của nút 8:
* **Trường hợp `parent[8] = 8`:** Xảy ra khi nhóm của 8 hoạt động hoàn toàn độc lập và chưa từng được `union` với nhóm 0 hay nhóm 4. Nút 8 tự làm gốc của chính nó.
* **Trường hợp `parent[8] = 0`:** Xảy ra khi có thao tác `union` gộp nhóm chứa 8 và nhóm chứa 0. Thuật toán so sánh kích thước hai gốc: size của gốc 8 (là 2) nhỏ hơn size của gốc 0 (là 4). Do đó, gốc 8 sẽ bị trỏ vào gốc 0.
* **Trường hợp `parent[8] = 4`:** Tương tự, khi `union` nhóm chứa 8 và nhóm chứa 4. Kích thước gốc 8 (là 2) nhỏ hơn gốc 4 (là 4), nên gốc 8 sẽ bị trỏ vào gốc 4.

**Tại sao không thể là các giá trị khác?**
Thuật toán luôn liên kết các **nút gốc** với nhau. Các giá trị 1, 2, 3, 5, 6, 7, 9 đều không phải là gốc của các cây lớn, do đó nút 8 không bao giờ trỏ vào chúng.