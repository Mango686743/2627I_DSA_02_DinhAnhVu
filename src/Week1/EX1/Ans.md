## Bài 1: Tìm bug trong cài đặt Quick-Find

Cài đặt `union(p, q)` trong đề bài mắc lỗi thay đổi dữ liệu trực tiếp trong lúc đang duyệt mảng. Khi phần tử ở vị trí `p` được cập nhật giá trị mới, các phần tử nằm sau nó (có index `i > p`) sẽ không thể so sánh đúng với `leader[p]` ban đầu nữa.

**Testcase chứng minh code chạy sai:**

*   **Giá trị n:** `4` (mảng khởi tạo `leader = [0, 1, 2, 3]`)
*   **Chuỗi phép toán:**
    1. `union(0, 1)`: Mảng cập nhật đúng thành `[1, 1, 2, 3]`. (0 và 1 chung tập hợp).
    2. `union(0, 2)`: Mảng bị cập nhật sai thành `[2, 1, 2, 3]`.
        *   *Giải thích lỗi:* Khi vòng lặp chạy tới `i = 0`, `leader[0]` bị thay đổi giá trị từ `1` thành `2`. Khi vòng lặp tiến tới `i = 1`, lệnh `if (leader[1] == leader[0])` trở thành `if (1 == 2)`, biểu thức sai. Do đó, phần tử ở index 1 bị bỏ qua không được cập nhật.

*   **Kết quả:**
    *   Chọn `i = 1`, `j = 2`.
    *   Theo chuỗi phép toán, 1 và 2 phải chung tập hợp. Nhưng khi gọi `find(1)` trả về `1`, còn `find(2)` trả về `2`. Kết quả khác nhau => Bug đã được bộc lộ.

**Cách sửa (Fix):**
Lưu giá trị `leader[p]` và `leader[q]` ra một biến tạm trước khi chạy vòng lặp `for`.