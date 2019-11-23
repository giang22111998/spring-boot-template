# Buổi 2. Dự án spring-boot web đầu tiên

Trong bài này chúng ta sẽ tìm hiểu về cách xây dựng controller để handle các request
Chúng ta lần lượt tìm hiểu về các annotation:
- @Controller: đánh dấu cho Spring boot biết class này là một controller
- @RequestMapping: annotation này bao gồm @GetMapping, @PostMapping, nó có mục đích sử dụng rộng hơn.
- @GetMapping: đánh dấu cho String boot biết đây là một hàm xử lý với method là GET
- @PostMapping: đánh dấu cho String boot biết đây là một hàm xử lý với method là POST
NOTE: khái niệm về method GET và POST các bạn tìm hiểu thêm trên google hoặc tại đây: https://vi.wikipedia.org/wiki/Hypertext_Transfer_Protocol#HTTP_Request_methods

```java
@Controller
@RequestMapping("/student")
public class StudentController {

    List<Student> studentList = new CopyOnWriteArrayList<>();

    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("student", new Student());
        return "student/addStudent";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Student student) {
        studentList.add(student);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String studentList(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        if (studentList.size() > 0) {
            if (limit != null && limit > studentList.size()) {
                limit = studentList.size();
            }
            model.addAttribute("studentList", limit != null ? studentList.subList(0, limit) : studentList);
        }
        return "student/listStudent";
    }
}
```


### Bật chế độ live reload

1. Ấn tổ hợp phím SHIFT+CTRL+A => gõ `registry`
2. Tích vào: `compiler.automake.allow.when.app.running`
