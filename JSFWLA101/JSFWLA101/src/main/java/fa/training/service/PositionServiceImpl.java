package fa.training.service;

import fa.training.entity.EipPosition;
import fa.training.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<EipPosition> getAllPositions() {
        // Truy vấn danh sách vị trí từ cơ sở dữ liệu
        return positionRepository.findAll();
    }
}
