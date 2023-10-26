const departmentList = document.getElementById("department-list");
const listContainer = document.getElementById("list-container");
const addButton = document.getElementById("add-button");
const deleteButton = document.getElementById("delete-button");
const selectedItemInput = document.getElementById("selected-item"); // Trường input ẩn

addButton.addEventListener("click", function () {
    // Lấy danh sách các item đã chọn
    const selectedItems = Array.from(listContainer.querySelectorAll(".list-item.selected"));

    // Di chuyển các item đã chọn vào phần Department
    selectedItems.forEach(item => {
        const clonedItem = item.cloneNode(true);
        departmentList.querySelector("div").appendChild(clonedItem);
        item.remove();
    });

    // Thu thập danh sách các mục đã chọn
    const selectedItemsValues = selectedItems.map(item => item.textContent);

    // Cập nhật giá trị của trường input ẩn
    selectedItemInput.value = selectedItemsValues.join(", "); // Đưa vào trường input, có thể sử dụng ký tự phân tách tùy ý (ở đây là dấu phẩy)

    // Gửi danh sách các mục đã chọn lên máy chủ (nếu cần)
});

// Sự kiện khi nhấn nút "Delete"
deleteButton.addEventListener("click", function () {
    // Lấy danh sách các item đã chọn
    const selectedItems = Array.from(departmentList.querySelectorAll(".list-item.selected"));

    // Di chuyển các item đã chọn vào phần list-container
    selectedItems.forEach(item => {
        const clonedItem = item.cloneNode(true);
        listContainer.appendChild(clonedItem);
        item.remove();
    });

    // Cập nhật giá trị của trường input ẩn khi bạn xóa các mục (nếu cần)
    const selectedItemsValues = selectedItems.map(item => item.textContent);
    selectedItemInput.value = selectedItemsValues.join(", ");
});

// Sự kiện khi click vào các item trong list-container hoặc department
listContainer.addEventListener("click", function (event) {
    const selectedItem = event.target;
    if (selectedItem.classList.contains("list-item")) {
        selectedItem.classList.toggle("selected");
    }
});

departmentList.addEventListener("click", function (event) {
    const selectedItem = event.target;
    if (selectedItem.classList.contains("list-item")) {
        selectedItem.classList.toggle("selected");
    }
});
