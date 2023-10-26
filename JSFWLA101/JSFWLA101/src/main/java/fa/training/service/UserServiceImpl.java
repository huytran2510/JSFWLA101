package fa.training.service;


import fa.training.dto.UserForCreate;
import fa.training.entity.EipCompany;
import fa.training.entity.EipPosition;
import fa.training.entity.EipPost;
import fa.training.entity.TurbineUser;
import fa.training.repository.CompanyRepository;
import fa.training.repository.PositionRepository;
import fa.training.repository.PostRepository;
import fa.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private CompanyService companyService;;


    public void addUser(TurbineUser turbineUser) {
        // Kiểm tra và tạo công ty nếu cần
        EipCompany eipCompany = turbineUser.getEipCompany();
        if (eipCompany != null && eipCompany.getCompanyName() != null) {
            EipCompany existingCompany = companyRepository.findByCompanyName(eipCompany.getCompanyName());
            if (existingCompany == null) {
                companyRepository.save(eipCompany);
            } else {
                // Cập nhật công ty nếu đã tồn tại
                eipCompany.setId(existingCompany.getId());
            }
        }
        // Lưu người dùng
        userRepository.save(turbineUser);
    }


    @Override
    public void addUserWithPosts(UserForCreate userForCreate) {
        // Tạo một đối tượng TurbineUser từ DTO
        TurbineUser turbineUser = new TurbineUser();
        // Thiết lập các giá trị từ userForCreate vào turbineUser
        turbineUser.setUsername(userForCreate.getUsername());
        turbineUser.setPassword(userForCreate.getPassword());
        turbineUser.setFirstname(userForCreate.getFirstname());
        turbineUser.setLastname(userForCreate.getLastname());
        turbineUser.setConfirmPassword(userForCreate.getConfirmPassword());
        turbineUser.setEmail(userForCreate.getEmail());
        turbineUser.setInPhone(userForCreate.getInPhone());
        turbineUser.setOutPhone(userForCreate.getOutPhone());
        turbineUser.setCellularPhone(userForCreate.getCellularPhone());
        turbineUser.setCellularEmail(userForCreate.getCellularEmail());
        turbineUser.setFile(userForCreate.getFile());

        // Lưu company vào turbineUser nếu có
        EipCompany eipCompany = userForCreate.getEipCompany();
        if (eipCompany != null) {
            turbineUser.setEipCompany(eipCompany);
        } else {
            String defaultCompanyName = "FPT SortWare";
            EipCompany defaultCompany = companyService.findByCompanyName(defaultCompanyName);
            if (defaultCompany == null) {
                // Nếu công ty mặc định chưa tồn tại, tạo một công ty mới
                defaultCompany = new EipCompany();
                defaultCompany.setCompanyName(defaultCompanyName);
                companyService.saveCompany(defaultCompany);
            }
            turbineUser.setEipCompany(defaultCompany);
        }

        // Lưu user
        userRepository.save(turbineUser);

        // Lấy danh sách postName từ DTO
        List<String> postNames = Collections.singletonList(userForCreate.getPostName());
        if (postNames != null && !postNames.isEmpty()) {
            for (String postName : postNames) {
                EipPost existingPost = postRepository.findByPostName(postName);
                if (existingPost == null) {
                    EipPost newPost = new EipPost();
                    newPost.setPostName(postName);
                    // Đảm bảo cập nhật company_id cho bài đăng
                    newPost.setEipCompany(turbineUser.getEipCompany());
                    postRepository.save(newPost);
                }
            }
        }

        // Lưu vị trí (Position) nếu đã chọn
        String name = userForCreate.getEipPosition().getName();
        if (name != null) {
            EipPosition position = positionRepository.findByName(name);
            if (position == null) {
                // Nếu không tồn tại EipPosition với tên đã cho, hãy tạo mới nó
                position = new EipPosition();
                position.setName(name);
                LocalDateTime createDate = LocalDateTime.now();
                position.setCreateDate(createDate);
                positionRepository.save(position);
            }
            // Sử dụng EipPosition (đã có hoặc mới tạo) trong turbineUser
            turbineUser.setEipPosition(position);
            userRepository.save(turbineUser);
        }
    }

    @Override
    public List<Object[]> list() {
        return userRepository.getUsernameNameAndPostName();
    }


    @Override
    public TurbineUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
